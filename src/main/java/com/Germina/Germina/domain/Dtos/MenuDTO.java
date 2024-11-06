package com.Germina.Germina.domain.Dtos;

import com.Germina.Germina.persistence.entities.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {

    private Long id;
    private List<Dish> dishes;
}
