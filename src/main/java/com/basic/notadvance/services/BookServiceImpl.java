package com.basic.notadvance.services;
import com.basic.notadvance.dto.BookRequestDTO;
import com.basic.notadvance.dto.BookResponseDTO;
import com.basic.notadvance.entity.Book;
import com.basic.notadvance.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements BookService {
        private final BookRepository bookRepository;

        public  BookServiceImpl(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        @Override
        public BookResponseDTO addBook(BookRequestDTO book) {
            Book newBook  = new Book();
            newBook.setTitle(book.getTitle());
            newBook.setAuthorName(book.getAuthorName());
            newBook.setIsbn(book.getIsbn());
            book.setNumberOfCopies(book.getNumberOfCopies());
            newBook.setSection(book.getSection());
            Book savedbook = bookRepository.save(newBook);
            return  toResponseDto(savedbook);
        }

        @Override
        public BookResponseDTO getBookById(Long id) {
            Book  book = bookRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
            return toResponseDto(book);
        }

        @Override
        public List<BookResponseDTO> getAllBooks(){
           return  bookRepository.findAll().stream().map(this::toResponseDto).collect(Collectors.toList());
        }

        @Override
        public BookResponseDTO updateBook(Long id, BookRequestDTO book) {
            Book existingBook = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("id not found " + id)); // reuse the method above
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthorName(book.getAuthorName());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setNumberOfCopies(book.getNumberOfCopies());
            existingBook.setSection(book.getSection());
            Book updateBook1 =  bookRepository.save(existingBook);
            return  toResponseDto(updateBook1);
        }

        @Override
        public void deleteBook(Long id) {
            Book existingBook = bookRepository.findById(id).orElseThrow(()->new RuntimeException("id not found" + id));
            bookRepository.delete(existingBook);
        }

        private  BookResponseDTO toResponseDto (Book book){
                    return new BookResponseDTO(
                            book.getId(),
                            book.getTitle(),
                            book.getAuthorName(),
                            book.getIsbn(),
                            book.getNumberOfCopies(),
                            book.getSection() );
        }
}
