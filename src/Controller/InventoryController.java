/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Book;
import Model.BookDAO;
import Model.BookOperations;
import View.ManagerDashboard;
import View.CashierDashboard;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class InventoryController {
    private ManagerDashboard managerView;
    private CashierDashboard cashierView;
    private BookOperations bookDAO;
    
    public InventoryController(ManagerDashboard view) {
        this.managerView = view;
        this.bookDAO = new BookDAO();
    }

    public InventoryController(CashierDashboard view) {
        this.cashierView = view;
        this.bookDAO = new BookDAO();
    }
    
    public boolean saveBook(String title, String author, String category, double price, int qty) {
        Book newBook = new Book(0, title, author, category, price, qty);
        return bookDAO.addBook(newBook);
    }
    
    public void loadInventory() {
        List<Book> bookList = bookDAO.getAllBooks(); 
        populateTable(bookList);
        checkAlerts(bookList); 
    }
    
    public void searchInventory(String keyword) {
        List<Book> searchResults = bookDAO.searchBooksByKeyword(keyword);
        populateTable(searchResults);
    }
    
    public boolean removeBook(int bookId) {
        return bookDAO.deleteBook(bookId);
    }

    public boolean updateBookDetails(int id, String title, String author, String category, double price, int qty) {
        Book updatedBook = new Book(id, title, author, category, price, qty);
        return bookDAO.updateBook(updatedBook);
    }
    
    private void populateTable(List<Book> list) {
        DefaultTableModel model;
        if (managerView != null) {
            model = (DefaultTableModel) managerView.getInventoryTable().getModel();
        } else {
            model = (DefaultTableModel) cashierView.getInventoryTable().getModel();
        }
        
        model.setRowCount(0);
        
        for (Book b : list) {
            String status = (b.getQuantity() < 10) ? "Low Stock" : "Good";
            
            Object[] row = {
                b.getBookId(),
                b.getTitle(),
                b.getAuthor(),
                b.getCategory(),
                b.getPrice(),
                b.getQuantity(),
                status
            };
            model.addRow(row); 
        }
    }
     
    private void checkAlerts(List<Book> list) {
        if (managerView == null) return; 

        int lowStockCount = 0;
        for (Book b : list) {
            if (b.getQuantity() < 10) {
                lowStockCount++;
            }
        }
        
        if (lowStockCount > 0) {
            managerView.setAlertMessage("WARNING: " + lowStockCount + " item(s) are running low on stock!");
        } else {
            managerView.setAlertMessage("SYSTEM ALERTS: All items are in good stock.");
        }
    }
    
    public void generateRestockReport() {
    List<Book> bookList = bookDAO.getAllBooks();
    StringBuilder report = new StringBuilder();
    report.append("==========================================\n");
    report.append("      BOOK HAVEN 22 - RESTOCK REPORT      \n");
    report.append("==========================================\n");
    report.append("Generated on: ").append(new java.util.Date()).append("\n\n");
    report.append(String.format("%-10s %-25s %-10s\n", "ID", "Title", "Qty"));
    report.append("------------------------------------------\n");

    boolean lowStockFound = false;
    for (Book b : bookList) {
        if (b.getQuantity() < 10) {
            report.append(String.format("%-10d %-25s %-10d\n", 
                b.getBookId(), b.getTitle(), b.getQuantity()));
            lowStockFound = true;
        }
    }

    if (!lowStockFound) {
        report.append("All items are currently in good stock levels.\n");
    }
    report.append("------------------------------------------\n");
    report.append("             End of Report                \n");

    try (java.io.FileWriter writer = new java.io.FileWriter("Restock_Report.txt")) {
        writer.write(report.toString());
        javax.swing.JOptionPane.showMessageDialog(null, "Report Generated: Restock_Report.txt");
        java.awt.Desktop.getDesktop().open(new java.io.File("Restock_Report.txt"));
    } catch (java.io.IOException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
}