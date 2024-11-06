package com.Germina.Germina.domain.Dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {

    private Long id;
    private String name;
    private String description;
    private String price;
    private String state;
    private Long amount;
}
