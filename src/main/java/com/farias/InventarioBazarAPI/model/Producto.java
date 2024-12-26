package com.farias.InventarioBazarAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private String nombre;
    private String marca;
    private double costo;
    private int cantidad_disponible;
    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;
}
