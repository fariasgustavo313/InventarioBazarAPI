package com.farias.InventarioBazarAPI.controller;

import com.farias.InventarioBazarAPI.dto.VentaProductoDTO;
import com.farias.InventarioBazarAPI.model.Venta;
import com.farias.InventarioBazarAPI.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/crear")
    public String crearVenta(@RequestBody Venta venta) {
        ventaService.crearVenta(venta);
        return "Venta creada con exito";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return "Venta eliminada con exito";
    }

    @PutMapping("/editar/{id}")
    public String editarVenta(@PathVariable Long id,
                              @RequestBody Venta venta) {
        ventaService.editarVenta(id, venta);
        return "Venta editada con exito";
    }

    @GetMapping("/{id}")
    public Venta obtenerVenta(@PathVariable Long id) {
        return ventaService.obtenerVenta(id);
    }

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @GetMapping("/ventas/productos/{id}")
    public VentaProductoDTO obtenerProductosPorVenta(@PathVariable Long id) {
        return ventaService.obtenerProductosPorVenta(id);
    }
}
