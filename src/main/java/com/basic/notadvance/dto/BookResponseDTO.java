package com.basic.notadvance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
    private Long id;
    private  String title;
    private String authorName;
    private  String isbn;
    private  int numberOfCopies;
    private  String section;

}
