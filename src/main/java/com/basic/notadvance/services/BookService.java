package com.basic.notadvance.services;
import com.basic.notadvance.entity.Book;
import java.util.List;


public interface BookService {
    Book addBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}