package com.basic.notadvance.controller;
import com.basic.notadvance.dto.BookRequestDTO;
import com.basic.notadvance.dto.BookResponseDTO;
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
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO book){
        BookResponseDTO savedBook = bookService.addBook(book);
        return  ResponseEntity.ok(savedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBook(@PathVariable Long id){
        BookResponseDTO ExistBook = bookService.getBookById(id);
        return ResponseEntity.ok(ExistBook);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        List<BookResponseDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
    @PutMapping ("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id ,  @RequestBody BookRequestDTO book){
        BookResponseDTO UpdatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(UpdatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
            bookService.deleteBook(id);
            return ResponseEntity.ok("Book deleted" + id);
    }


    

}
