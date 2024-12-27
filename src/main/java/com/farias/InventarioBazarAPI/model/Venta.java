package com.farias.InventarioBazarAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    private LocalDate fecha_venta;
    private double total;
    @OneToMany
    private List<Producto> listaProductos;
    @OneToOne
    @JoinColumn(name = "id_cliente",
                referencedColumnName = "id_cliente")
    private Cliente cliente;

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId_venta() {
        return id_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public double getTotal() {
        return total;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Venta(Long id_venta, LocalDate fecha_venta, double total, List<Producto> listaProductos, Cliente cliente) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.cliente = cliente;
    }

    public Venta() {
    }
}
