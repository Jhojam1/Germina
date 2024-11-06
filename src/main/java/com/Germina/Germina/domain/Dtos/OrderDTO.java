package com.Germina.Germina.domain.Dtos;

import com.Germina.Germina.persistence.entities.Menu;
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

    private int id;
    private User user;
    private Menu menu;
    private Date fechaPedido;
}
