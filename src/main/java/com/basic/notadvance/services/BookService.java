package com.basic.notadvance.services;
import com.basic.notadvance.dto.BookRequestDTO;
import com.basic.notadvance.dto.BookResponseDTO;
import com.basic.notadvance.entity.Book;
import java.util.List;


public interface BookService {
    BookResponseDTO addBook(BookRequestDTO book);
    BookResponseDTO getBookById(Long id);
    List<BookResponseDTO> getAllBooks();
    BookResponseDTO updateBook(Long id, BookRequestDTO book);
    void deleteBook(Long id);
}