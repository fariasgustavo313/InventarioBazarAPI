package com.farias.InventarioBazarAPI.dto;

import com.farias.InventarioBazarAPI.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaProductoDTO {

    private Long id_venta;
    private LocalDate fecha_venta;
    private List<Producto> listaProductos;
}
