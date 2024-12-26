package com.farias.InventarioBazarAPI.service;

import com.farias.InventarioBazarAPI.model.Venta;
import com.farias.InventarioBazarAPI.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public void crearVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    public void editarVenta(Long id, Venta venta) {
        Venta vta = ventaRepository.findById(id).orElse(null);
        vta.setFecha_venta(venta.getFecha_venta());
        vta.setListaProductos(venta.getListaProductos());
        vta.setTotal(venta.getTotal());
        vta.setCliente(venta.getCliente());

        ventaRepository.save(vta);
    }

    public Venta obtenerVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }
}
