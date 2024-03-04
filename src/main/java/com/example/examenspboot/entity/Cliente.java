package com.example.examenspboot.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Long total;

    private String estado;

    // Constructor, getters y setters
    public Cliente() {
    }

}
