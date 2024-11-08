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
public class ConfigHr {
    @Id
    private String id;

    @Column(name = "Hora")
    private String value;
}
