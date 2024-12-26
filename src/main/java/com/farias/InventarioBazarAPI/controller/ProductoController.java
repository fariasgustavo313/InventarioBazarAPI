package com.farias.InventarioBazarAPI.controller;

import com.farias.InventarioBazarAPI.model.Producto;
import com.farias.InventarioBazarAPI.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public String crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return "Producto creado con exito";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "Producto eliminado con exito";
    }

    @PutMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id,
                                 @RequestBody Producto producto) {
        productoService.editarProducto(id, producto);
        return "Producto editado con exito";
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProducto(id);
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }
}
