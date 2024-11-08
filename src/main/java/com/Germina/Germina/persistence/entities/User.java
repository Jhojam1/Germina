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
@Table(name = "Usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombres_Completos")
    private String fullName;

    @Column(name = "Numero_Identificacion")
    private Long numberIdentification;

    @Column(name = "Estado")
    private String state;

    @Column(name = "Correo")
    private String mail;

}
