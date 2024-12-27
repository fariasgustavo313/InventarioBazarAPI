package com.farias.InventarioBazarAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getCosto() {
        return costo;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public Venta getVenta() {
        return venta;
    }

    public Producto(Long id_producto, String nombre, String marca, double costo, int cantidad_disponible, Venta venta) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        this.venta = venta;
    }

    public Producto() {
    }
}
