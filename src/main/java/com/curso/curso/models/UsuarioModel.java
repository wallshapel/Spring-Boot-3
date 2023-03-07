package com.curso.curso.models;

import lombok.Data;

import javax.persistence.*;

@Entity  // Con este decorador indicamos que esta clase será una entidad (tabla) y no una simple clase plana
@Table(name = "usuarios")  // especificamos el nombre de la tabla asociada a este modelo
@Data
public class UsuarioModel {
    @Id  // Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremental
    private Long id;
    @Column(name = "nombre", nullable = false, length = 75)  // Esto es opcional, pero es bueno; sin embargo, lo que cuenta es la línea de abajo.
    private String nombre;
    @Column(name = "email", nullable = true, length = 75)
    private String email;
    @Column(name = "telefono", nullable = true, length = 75)
    private String telefono;
    @Column(name = "pass", nullable = false, length = 255)
    private String pass;
}