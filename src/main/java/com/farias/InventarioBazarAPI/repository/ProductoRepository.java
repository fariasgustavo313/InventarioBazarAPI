package com.farias.InventarioBazarAPI.repository;

import com.farias.InventarioBazarAPI.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
