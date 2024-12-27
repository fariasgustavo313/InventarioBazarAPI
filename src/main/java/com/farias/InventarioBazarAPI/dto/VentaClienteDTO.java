package com.farias.InventarioBazarAPI.dto;

public class VentaClienteDTO {

    private Long id_venta;
    private double total_venta;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    public void setCantidad_productos(int cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public Long getId_venta() {
        return id_venta;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public int getCantidad_productos() {
        return cantidad_productos;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public VentaClienteDTO(Long id_venta, double total_venta, int cantidad_productos, String nombre_cliente, String apellido_cliente) {
        this.id_venta = id_venta;
        this.total_venta = total_venta;
        this.cantidad_productos = cantidad_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }

    public VentaClienteDTO() {
    }
}
