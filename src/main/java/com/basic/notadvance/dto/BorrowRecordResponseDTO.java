package com.basic.notadvance.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowRecordResponseDTO {
        private  Long id;
        private Long bookId;
        private String bookTitle;
        private Long memberId;
        private String memberName;
        private LocalDate borrowDate;
        private  LocalDate dueDate;
        private  LocalDate returnDate;
}
