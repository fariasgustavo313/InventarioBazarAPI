package com.farias.InventarioBazarAPI.dto;

public class VentaDTO {

    private double total;
    private int cantidad_ventas;

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCantidad_ventas(int cantidad_ventas) {
        this.cantidad_ventas = cantidad_ventas;
    }

    public double getTotal() {
        return total;
    }

    public int getCantidad_ventas() {
        return cantidad_ventas;
    }

    public VentaDTO(double total, int cantidad_ventas) {
        this.total = total;
        this.cantidad_ventas = cantidad_ventas;
    }

    public VentaDTO() {
    }
}
