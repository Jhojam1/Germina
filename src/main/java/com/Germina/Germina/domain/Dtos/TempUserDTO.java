package com.Germina.Germina.domain.Dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class TempUserDTO {

    private Long id;
    private String fullName;
    private Long numberIdentification;
    private String mail;

}
