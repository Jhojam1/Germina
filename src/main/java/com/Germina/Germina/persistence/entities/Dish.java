package com.Germina.Germina.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Platos")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre_Plato")
    private String name;

    @Column(name = "Descripcion_Plato")
    private String description;

    @Column(name = "Precio")
    private String price;

    @Column(name = "Estado")
    private String state;

    @Column(name = "Cantidad")
    private Long amount; // Cantidad disponible total

    @Column(name = "Cantidad_Maxima_Diaria")
    private Long maxDailyAmount; // Límite de pedidos diarios

    @Column(name = "Cantidad_Pedidos_Hoy")
    private Long ordersToday = 0L; // Contador de pedidos realizados hoy

    @Column(name = "Fecha_Ultima_Actualizacion")
    private LocalDate lastUpdatedDate = LocalDate.now(); // Fecha de última actualización del contador

    public boolean isAvailable() {
        // Si ha cambiado el día, reinicia el contador de pedidos
        if (!LocalDate.now().equals(lastUpdatedDate)) {
            ordersToday = 0L;
            lastUpdatedDate = LocalDate.now();
        }
        // Verifica si hay pedidos disponibles
        return ordersToday < maxDailyAmount;
    }

    public void incrementOrdersToday() {
        ordersToday++;
    }
}
