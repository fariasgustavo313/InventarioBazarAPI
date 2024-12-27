package com.farias.InventarioBazarAPI.controller;

import com.farias.InventarioBazarAPI.model.Producto;
import com.farias.InventarioBazarAPI.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Operation(summary = "Crear un producto", description = "Permite crear un nuevo producto")
    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente")
    @PostMapping("/crear")
    public String crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return "Producto creado con exito";
    }

    @Operation(summary = "Eliminar un producto", description = "Permite eliminar un producto existente")
    @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente")
    @DeleteMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "Producto eliminado con exito";
    }

    @Operation(summary = "Editar un producto", description = "Permite editar un producto existente")
    @ApiResponse(responseCode = "200", description = "Producto editado exitosamente")
    @PutMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id,
                                 @RequestBody Producto producto) {
        productoService.editarProducto(id, producto);
        return "Producto editado con exito";
    }

    @Operation(summary = "Obtener un producto", description = "Permite obtener un producto por ID")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProducto(id);
    }

    @Operation(summary = "Obtener lista de productos", description = "Permite obtener todos los productos")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @ApiResponse(responseCode = "404", description = "Productos no encontrados")
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @Operation(summary = "Obtener productos por cantidad", description = "Permite obtener una lista de productos por cantidad")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @ApiResponse(responseCode = "404", description = "Productos no encontrados")
    @GetMapping("/stock/{cantidad}")
    public List<Producto> obtenerProductosPorCantidad(@PathVariable int cantidad) {
        return productoService.obtenerProductosPorCantidad(cantidad);
    }
}
