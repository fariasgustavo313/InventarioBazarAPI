package com.farias.InventarioBazarAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaClienteDTO {

    private Long id_venta;
    private double total_venta;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;
}
