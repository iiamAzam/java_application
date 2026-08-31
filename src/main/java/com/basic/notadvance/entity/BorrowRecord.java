package com.basic.notadvance.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "borrow_records")
@NoArgsConstructor
@AllArgsConstructor
public class BorrowRecord {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            @ManyToOne
            @JoinColumn(name = "book_id" , nullable = false)
            private Book  book;

            @ManyToOne
            @JoinColumn(name = "member_id", nullable = false)
            private Member member;

            @Column(nullable = false)
            private LocalDate borrowDate;

            @Column(nullable = false)
            private  LocalDate dueDate;

            private LocalDate returnDate;


}
