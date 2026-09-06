package com.basic.notadvance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDTO {
            private  Long id ;
            private  String name;
            private  String phone ;
            private  String email ;
            private LocalDate membershipDate;


}
