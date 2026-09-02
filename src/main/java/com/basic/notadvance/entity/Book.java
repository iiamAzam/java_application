package com.basic.notadvance.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor


public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String authorName;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
        private int numberOfCopies;
    @Column(nullable = false)
    private String section;



}
