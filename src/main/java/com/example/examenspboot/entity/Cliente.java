package com.example.examenspboot;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCliente;

    private Long totalVentas;

    private String estado;

    // Constructor, getters y setters
    public Cliente() {
    }

    public Cliente(String nombreCliente, Long totalVentas, String estado) {
        this.nombreCliente = nombreCliente;
        this.totalVentas = totalVentas;
        this.estado = estado;
    }
}
