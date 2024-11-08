package com.Germina.Germina.domain.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private Long ordersToday; // Contador de pedidos realizados hoy
    private LocalDate lastUpdatedDate; // Fecha de la última actualización del contador diario
    private Long maxDailyAmount; // Límite de pedidos diarios

}
