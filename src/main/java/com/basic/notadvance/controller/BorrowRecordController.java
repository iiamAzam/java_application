package com.basic.notadvance.controller;
import com.basic.notadvance.dto.BorrowRecordRequestDTO;
import com.basic.notadvance.dto.BorrowRecordResponseDTO;
import com.basic.notadvance.services.BorrowRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/borrow-records")
public class BorrowRecordController {
    private  final BorrowRecordService borrowRecordService;
    public  BorrowRecordController (BorrowRecordService borrowRecordService){
        this.borrowRecordService = borrowRecordService;
    }
    @PostMapping("/borrow")
    public ResponseEntity<BorrowRecordResponseDTO> borrowBook (@RequestBody BorrowRecordRequestDTO request){
            BorrowRecordResponseDTO recordResponse = borrowRecordService.borrowBook(request);
            return ResponseEntity.ok(recordResponse) ;
    }

    @PutMapping("/{id}/return")
    public  ResponseEntity<BorrowRecordResponseDTO> returnBook (@PathVariable Long id){
            return  ResponseEntity.ok(borrowRecordService.returnBook(id));
    }
    @GetMapping
    public ResponseEntity<List<BorrowRecordResponseDTO>> getAllRecords () {
        return  ResponseEntity.ok(borrowRecordService.getAllBorrowRecords());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<BorrowRecordResponseDTO>getSingleRecord(@PathVariable Long id){
        return  ResponseEntity.ok(borrowRecordService.getBorrowRecordById(id));
    }



    }