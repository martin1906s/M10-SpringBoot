package com.krake2.veterinaria2.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota", unique=true)
    private int id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name="especie", nullable=false)
    private String especie;

    @Column(name="edad")
    private int edad;

    @Column(name = "nombre_dueno", nullable = false, length = 100)
    private String nombreDueno;

    @Column(name="fecha_registro", nullable=false)
    private LocalDate fechaRegistro;
}
