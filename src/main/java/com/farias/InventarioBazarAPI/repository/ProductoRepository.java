package com.farias.InventarioBazarAPI.repository;

import com.farias.InventarioBazarAPI.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.cantidad_disponible = :cantidad_disponible")
    List<Producto> obtenerProductosPorCantidad(@Param("cantidad_disponible")int cantidad_disponible);
}
