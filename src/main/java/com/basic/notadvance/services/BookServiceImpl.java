package com.basic.notadvance.services;

import com.basic.notadvance.entity.Book;
import com.basic.notadvance.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
        private final BookRepository bookRepository;

        public  BookServiceImpl(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        @Override
        public Book addBook(Book book) {
            return bookRepository.save(book);
        }

        @Override
        public Book getBookById(Long id) {
            return bookRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        }

        @Override
        public List<Book> getAllBooks() {
            return bookRepository.findAll();
        }

        @Override
        public Book updateBook(Long id, Book book) {
            Book existingBook = getBookById(id); // reuse the method above
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthorName(book.getAuthorName());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setNumberOfCopies(book.getNumberOfCopies());
            existingBook.setSection(book.getSection());
            return bookRepository.save(existingBook);
        }

        @Override
        public void deleteBook(Long id) {
            Book existingBook = getBookById(id);
            bookRepository.delete(existingBook);
        }
}
