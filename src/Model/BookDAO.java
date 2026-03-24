/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements BookOperations {
    
    @Override
    public boolean addBook(Book book) {
        String sql = "INSERT INTO books (title, author, category, price, quantity) VALUES (?, ?, ?, ?, ?)";
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setString(3, book.getCategory());
            pst.setDouble(4, book.getPrice());
            pst.setInt(5, book.getQuantity());
            
            int result = pst.executeUpdate();
            con.close();
            return result > 0;
        }
        
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Book b = new Book();
                b.setBookId(rs.getInt("book_id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setCategory(rs.getString("category"));
                b.setPrice(rs.getDouble("price"));
                b.setQuantity(rs.getInt("quantity"));
                
                list.add(b);   
            }
            con.close();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public Book searchBook(String title) {
        Book b = null;
        String sql = "SELECT * FROM books WHERE title LIKE ?";
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + title + "%");
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                b = new Book();
                b.setBookId(rs.getInt("book_id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setCategory(rs.getString("category"));
                b.setPrice(rs.getDouble("price"));
                b.setQuantity(rs.getInt("quantity"));
            }
            con.close();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    
    @Override
    public List<Book> searchBooksByKeyword(String keyword) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR category LIKE ?";
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            String searchPattern = "%" + keyword + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);
            pst.setString(3, searchPattern);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                Book b = new Book();
                b.setBookId(rs.getInt("book_id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setCategory(rs.getString("category"));
                b.setPrice(rs.getDouble("price"));
                b.setQuantity(rs.getInt("quantity"));
                
                list.add(b);   
            }
            con.close();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public boolean updateBook(Book book) {
        String sql = "UPDATE books SET title=?, author=?, category=?, price=?, quantity=? WHERE book_id=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setString(3, book.getCategory());
            pst.setDouble(4, book.getPrice());
            pst.setInt(5, book.getQuantity());
            pst.setInt(6, book.getBookId());
            int result = pst.executeUpdate();
            con.close();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBook(int bookId) {
        String sql = "DELETE FROM books WHERE book_id=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            int result = pst.executeUpdate();
            con.close();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
