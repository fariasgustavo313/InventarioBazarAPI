package com.farias.InventarioBazarAPI.controller;

import com.farias.InventarioBazarAPI.dto.VentaClienteDTO;
import com.farias.InventarioBazarAPI.dto.VentaDTO;
import com.farias.InventarioBazarAPI.dto.VentaProductoDTO;
import com.farias.InventarioBazarAPI.model.Venta;
import com.farias.InventarioBazarAPI.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Operation(summary = "Crear una venta", description = "Permite crear una nueva venta")
    @ApiResponse(responseCode = "201", description = "Venta creada exitosamente")
    @PostMapping("/crear")
    public String crearVenta(@RequestBody Venta venta) {
        ventaService.crearVenta(venta);
        return "Venta creada con exito";
    }

    @Operation(summary = "Eliminar una venta", description = "Permite eliminar una venta existente")
    @ApiResponse(responseCode = "204", description = "Venta eliminada exitosamente")
    @DeleteMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return "Venta eliminada con exito";
    }

    @Operation(summary = "Editar una venta", description = "Permite editar una venta existente")
    @ApiResponse(responseCode = "200", description = "Venta editada exitosamente")
    @PutMapping("/editar/{id}")
    public String editarVenta(@PathVariable Long id,
                              @RequestBody Venta venta) {
        ventaService.editarVenta(id, venta);
        return "Venta editada con exito";
    }

    @Operation(summary = "Obtener una venta", description = "Permite obtener una venta por ID")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @ApiResponse(responseCode = "404", description = "Venta no encontrada")
    @GetMapping("/{id}")
    public Venta obtenerVenta(@PathVariable Long id) {
        return ventaService.obtenerVenta(id);
    }

    @Operation(summary = "Obtener lista de ventas", description = "Permite obtener todas las ventas")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @ApiResponse(responseCode = "404", description = "Ventas no encontradas")
    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @Operation(summary = "Obtener productos por venta", description = "Permite obtener todos los productos de una venta")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @ApiResponse(responseCode = "404", description = "Venta no encontrada")
    @GetMapping("/ventas/productos/{id}")
    public VentaProductoDTO obtenerProductosPorVenta(@PathVariable Long id) {
        return ventaService.obtenerProductosPorVenta(id);
    }

    @Operation(summary = "Obtener total y cantidad de ventas", description = "Permite obtener la suma total y la cantidad de ventas de un determinado dia")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @ApiResponse(responseCode = "404", description = "Ventas no encontradas")
    @GetMapping("/fecha/{fecha_venta}")
    public VentaDTO obtenerTotalYCantidadVentasPorDia(@PathVariable LocalDate fecha_venta) {
        return ventaService.obtenerTotalYCantidadVentasPorDia(fecha_venta);
    }

    @Operation(summary = "Obtener mayor venta", description = "Permite obtener los datos de la venta mas alta")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @GetMapping("/mayor_venta")
    public VentaClienteDTO obtenerMayorVenta() {
        return ventaService.obtenerMayorVenta();
    }
}
