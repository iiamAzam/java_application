package com.basic.notadvance.controller;


import com.basic.notadvance.entity.Book;
import com.basic.notadvance.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
                this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book savedBook = bookService.addBook(book);
        return  ResponseEntity.ok(savedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book ExistBook = bookService.getBookById(id);
        return ResponseEntity.ok(ExistBook);
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
    @PutMapping ("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id ,  @RequestBody Book book){
        Book UpdatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(UpdatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
            bookService.deleteBook(id);
            return ResponseEntity.ok("Book deleted" + id);
    }


    

}
