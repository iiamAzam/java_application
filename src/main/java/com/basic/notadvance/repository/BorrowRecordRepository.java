package com.basic.notadvance.repository;
import com.basic.notadvance.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRecordRepository  extends   JpaRepository<BorrowRecord,Long>{

}
