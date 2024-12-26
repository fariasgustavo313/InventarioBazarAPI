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
        try {
            if (producto.getNombre().isEmpty() || producto.getMarca().isEmpty() || producto.getCosto() < 0 || producto.getCantidad_disponible() < 0) {
                throw new Exception("Los datos ingresados son erroneos");
            } else {
                productoRepository.save(producto);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public void editarProducto(Long id, Producto producto) {
        Producto prod = productoRepository.findById(id).orElse(null);
        try {
            if (producto.getNombre().isEmpty() || producto.getMarca().isEmpty()) {
                throw new Exception("Los cambios nombre y marca no pueden estas vacios");
            } else {
                prod.setNombre(producto.getNombre());
                prod.setMarca(producto.getMarca());
            }

            if (producto.getCosto() < 0 || producto.getCantidad_disponible() < 0) {
                throw new Exception(("Los valores de costo y cantidad disponible no pueden ser negativos"));
            } else {
                prod.setCosto(producto.getCosto());
                prod.setCantidad_disponible(producto.getCantidad_disponible());
            }
            productoRepository.save(prod);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Producto obtenerProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }
}
