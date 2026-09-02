package com.basic.notadvance.services;

import com.basic.notadvance.entity.Book;
import com.basic.notadvance.entity.BorrowRecord;
import com.basic.notadvance.entity.Member;
import com.basic.notadvance.repository.BookRepository;
import com.basic.notadvance.repository.BorrowRecordRepository;
import com.basic.notadvance.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
                     public BorrowRecord borrowBook(Long bookId, Long memberId){
                         Member getMember  =  memberrepository.findById(memberId).orElseThrow(()-> new RuntimeException("Member not found "));
                         Book getBook = bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found "));

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
                         borrowRecordRepository.save(borrowRecord);
                         return  borrowRecord;


                    }

    @Override
    public BorrowRecord returnBook(Long borrowRecordId) {
        BorrowRecord record = borrowRecordRepository.findById(borrowRecordId).orElseThrow(()-> new RuntimeException("Record not found "));
        record.setReturnDate(LocalDate.now());
        Book bookTaken = record.getBook();
        int count  = bookTaken.getNumberOfCopies();
        bookTaken.setNumberOfCopies(count+1);
        bookRepository.save(bookTaken);
        borrowRecordRepository.save(record);
        return record;
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    @Override
    public BorrowRecord getBorrowRecordById(Long borrowRecordId) {
        return borrowRecordRepository.findById(borrowRecordId).orElseThrow(()-> new RuntimeException("Reocrd not found"));
    }
}
