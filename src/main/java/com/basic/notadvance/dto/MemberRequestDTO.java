package com.basic.notadvance.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDTO {
            private  String name;
            private String phone ;
            private  String email ;
            private  LocalDate membershipDate;
}

