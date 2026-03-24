/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.util.List;

public interface BookOperations {
    
    public boolean addBook(Book book);
    
    public boolean updateBook(Book book);
    
    public boolean deleteBook(int bookId);
    
    public Book searchBook(String title);
    
    public List <Book> getAllBooks();
    
    public List<Book> searchBooksByKeyword(String keyword);
    
}
