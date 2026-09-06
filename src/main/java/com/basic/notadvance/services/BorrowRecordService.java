package com.basic.notadvance.services;
import com.basic.notadvance.dto.BorrowRecordRequestDTO;
import com.basic.notadvance.dto.BorrowRecordResponseDTO;
import com.basic.notadvance.entity.Book;
import com.basic.notadvance.entity.BorrowRecord;

import java.util.List;

public interface BorrowRecordService {
            BorrowRecordResponseDTO borrowBook(BorrowRecordRequestDTO Dto );
            BorrowRecordResponseDTO returnBook(Long borrowRecordId);
            List<BorrowRecordResponseDTO> getAllBorrowRecords();
            BorrowRecordResponseDTO getBorrowRecordById(Long borrowRecordId);


}