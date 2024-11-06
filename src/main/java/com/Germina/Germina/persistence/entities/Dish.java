package com.Germina.Germina.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long amount;
}
