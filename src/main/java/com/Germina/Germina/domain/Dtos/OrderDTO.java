package com.Germina.Germina.domain.Dtos;

import com.Germina.Germina.persistence.entities.Dish;
import com.Germina.Germina.persistence.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private User user;
    private Dish dish; // Agregar referencia al plato
    private Date fechaPedido;
}
