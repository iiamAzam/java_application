package com.basic.notadvance.services;
import com.basic.notadvance.entity.Book;
import com.basic.notadvance.entity.BorrowRecord;

import java.util.List;

public interface BorrowRecordService {
            BorrowRecord borrowBook(Long bookId, Long memberId);
            BorrowRecord returnBook(Long borrowRecordId);
            List<BorrowRecord> getAllBorrowRecords();
            BorrowRecord getBorrowRecordById(Long borrowRecordId);


}