package com.farias.InventarioBazarAPI.repository;

import com.farias.InventarioBazarAPI.dto.VentaDTO;
import com.farias.InventarioBazarAPI.model.Producto;
import com.farias.InventarioBazarAPI.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT SUM(v.total), COUNT(v) FROM Venta v WHERE v.fecha_venta = :fecha_venta")
    VentaDTO obtenerTotalYCantidadVentasPorDia(@Param("fecha_venta") LocalDate fecha_venta);

    @Query("SELECT v FROM Venta v ORDER BY v.total DESC")
    List<Venta> obtenerMayorVenta();
}
