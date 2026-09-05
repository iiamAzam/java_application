package com.basic.notadvance.controller;
import com.basic.notadvance.entity.BorrowRecord;
import com.basic.notadvance.services.BorrowRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/borrow-records")
public class BorrowRecordController {
    private  final BorrowRecordService borrowRecordService;
    public  BorrowRecordController (BorrowRecordService borrowRecordService){
        this.borrowRecordService = borrowRecordService;
    }
    @PostMapping("/borrow")
    public ResponseEntity<BorrowRecord> borrowBook (@RequestBody Map<String, Long> request){
            Long bookId = request.get("bookId");
            Long memberId = request.get("memberId");
            return ResponseEntity.ok(borrowRecordService.borrowBook(bookId, memberId)) ;
    }

    @PutMapping("/{id}/return")
    public  ResponseEntity<BorrowRecord> returnBook (@PathVariable Long id){
            return  ResponseEntity.ok(borrowRecordService.returnBook(id));
    }
    @GetMapping
    public ResponseEntity<List<BorrowRecord>> getAllRecords () {
        return  ResponseEntity.ok(borrowRecordService.getAllBorrowRecords());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<BorrowRecord>getSingleRecord(@PathVariable Long id){
        return  ResponseEntity.ok(borrowRecordService.getBorrowRecordById(id));
    }



    }