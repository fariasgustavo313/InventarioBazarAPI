package com.farias.InventarioBazarAPI.service;

import com.farias.InventarioBazarAPI.model.Producto;
import com.farias.InventarioBazarAPI.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public void crearProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public void editarProducto(Long id, Producto producto) {
        Producto prod = productoRepository.findById(id).orElse(null);
        prod.setNombre(producto.getNombre());
        prod.setMarca(producto.getMarca());
        prod.setCosto(producto.getCosto());
        prod.setCantidad_disponible(producto.getCantidad_disponible());

        productoRepository.save(prod);
    }

    public Producto obtenerProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }
}
