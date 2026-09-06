package com.basic.notadvance.services;

import com.basic.notadvance.dto.BorrowRecordRequestDTO;
import com.basic.notadvance.dto.BorrowRecordResponseDTO;
import com.basic.notadvance.entity.Book;
import com.basic.notadvance.entity.BorrowRecord;
import com.basic.notadvance.entity.Member;
import com.basic.notadvance.repository.BookRepository;
import com.basic.notadvance.repository.BorrowRecordRepository;
import com.basic.notadvance.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
                    private  final  BorrowRecordRepository borrowRecordRepository;
                    private final  MemberRepository memberrepository;
                    private  final BookRepository bookRepository ;
                    public  BorrowRecordServiceImpl(BorrowRecordRepository borrowRecordRepository, MemberRepository memberrepository, BookRepository bookRepository){
                                this.borrowRecordRepository=borrowRecordRepository;
                                this.memberrepository = memberrepository;
                                this.bookRepository = bookRepository;
                    }
                     @Override
                     public BorrowRecordResponseDTO borrowBook(BorrowRecordRequestDTO dto){
                         Member getMember  =  memberrepository.findById(dto.getMemberId()).orElseThrow(()-> new RuntimeException("Member not found "));
                         Book getBook = bookRepository.findById(dto.getBookId()).orElseThrow(()-> new RuntimeException("Book not found "));
                         BorrowRecord borrowRecord = new BorrowRecord();
                         LocalDate today = LocalDate.now();
                         int count = getBook.getNumberOfCopies();
                         if(count<=0)
                         {
                             throw  new RuntimeException("no copies available");
                         }
                         getBook.setNumberOfCopies(count-1);
                         borrowRecord.setBook(getBook);
                         borrowRecord.setMember(getMember);
                         borrowRecord.setBorrowDate(today);
                         borrowRecord.setDueDate(today.plusDays(14));
                         borrowRecord.setReturnDate(null);
                         bookRepository.save(getBook);
                         BorrowRecord SavedRecord =  borrowRecordRepository.save(borrowRecord);
                         return  toResponseDTO(SavedRecord);


                    }

    @Override
    public BorrowRecordResponseDTO returnBook(Long borrowRecordId) {
        BorrowRecord record = borrowRecordRepository.findById(borrowRecordId).orElseThrow(()-> new RuntimeException("Record not found "));
        record.setReturnDate(LocalDate.now());
        Book bookTaken = record.getBook();
        int count  = bookTaken.getNumberOfCopies();
        bookTaken.setNumberOfCopies(count+1);
        bookRepository.save(bookTaken);
       BorrowRecord updatedRecord =  borrowRecordRepository.save(record);
        return toResponseDTO(updatedRecord);
    }

    @Override
    public List<BorrowRecordResponseDTO> getAllBorrowRecords() {
        return borrowRecordRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
    @Override
    public BorrowRecordResponseDTO getBorrowRecordById(Long borrowRecordId) {
                    BorrowRecord borrowRecord = borrowRecordRepository.findById(borrowRecordId).orElseThrow( ()-> new RuntimeException("record not found of id "+ borrowRecordId));
                    return toResponseDTO(borrowRecord);
    }
    private  BorrowRecordResponseDTO toResponseDTO(BorrowRecord borrowRecord){
                       return  new BorrowRecordResponseDTO(
                               borrowRecord.getId(),
                               borrowRecord.getBook().getId(),
                               borrowRecord.getBook().getTitle(),
                               borrowRecord.getMember().getId(),
                               borrowRecord.getMember().getName(),
                               borrowRecord.getBorrowDate(),
                               borrowRecord.getDueDate(),
                               borrowRecord.getReturnDate()
                       );
    }
}
