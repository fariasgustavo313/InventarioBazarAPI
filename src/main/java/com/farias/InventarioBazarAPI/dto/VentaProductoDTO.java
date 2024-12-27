package com.farias.InventarioBazarAPI.dto;

import com.farias.InventarioBazarAPI.model.Producto;

import java.time.LocalDate;
import java.util.List;

public class VentaProductoDTO {

    private Long id_venta;
    private LocalDate fecha_venta;
    private List<Producto> listaProductos;

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Long getId_venta() {
        return id_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public VentaProductoDTO(Long id_venta, LocalDate fecha_venta, List<Producto> listaProductos) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.listaProductos = listaProductos;
    }

    public VentaProductoDTO() {
    }
}
