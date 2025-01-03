package com.farias.InventarioBazarAPI.service;

import com.farias.InventarioBazarAPI.dto.VentaClienteDTO;
import com.farias.InventarioBazarAPI.dto.VentaDTO;
import com.farias.InventarioBazarAPI.dto.VentaProductoDTO;
import com.farias.InventarioBazarAPI.model.Producto;
import com.farias.InventarioBazarAPI.model.Venta;
import com.farias.InventarioBazarAPI.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public void crearVenta(Venta venta) {
        try {
            double total = 0;
            List<Producto> listaProductos = venta.getListaProductos();
            for (Producto producto : listaProductos) {
                if (producto.getCantidad_disponible() < 1) {
                    throw new Exception("No hay stock disponible para realizar la venta");
                } else {
                    int cantidad = producto.getCantidad_disponible() - 1;
                    producto.setCantidad_disponible(cantidad);
                    total += producto.getCosto();
                }
            }
            venta.setFecha_venta(LocalDate.now());
            venta.setTotal(total);
            ventaRepository.save(venta);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    public void editarVenta(Long id, Venta venta) {
        try {
            double total = 0;
            Venta vta = ventaRepository.findById(id).orElse(null);
            List<Producto> listaProductos = venta.getListaProductos();
            for (Producto producto : listaProductos) {
                if (producto.getCantidad_disponible() < 1) {
                    throw new Exception("No hay stock disponible para realizar la venta");
                } else {
                    int cantidad = producto.getCantidad_disponible() - 1;
                    producto.setCantidad_disponible(cantidad);
                    total += producto.getCosto();
                }
            }
            vta.setListaProductos(venta.getListaProductos());
            vta.setCliente(venta.getCliente());
            ventaRepository.save(vta);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Venta obtenerVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public VentaProductoDTO obtenerProductosPorVenta(Long id) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        VentaProductoDTO vtaProdDTO = new VentaProductoDTO();
        vtaProdDTO.setFecha_venta(venta.getFecha_venta());
        vtaProdDTO.setListaProductos(venta.getListaProductos());
        return vtaProdDTO;
    }

    public VentaDTO obtenerTotalYCantidadVentasPorDia(LocalDate fecha_venta) {
        return ventaRepository.obtenerTotalYCantidadVentasPorDia(fecha_venta);
    }

    public VentaClienteDTO obtenerMayorVenta() {
        Venta venta = ventaRepository.obtenerMayorVenta().stream().findFirst().orElse(null);
        VentaClienteDTO vtaCliDTO = new VentaClienteDTO();

        vtaCliDTO.setId_venta(venta.getId_venta());
        vtaCliDTO.setTotal_venta(venta.getTotal());

        int cantidad = venta.getListaProductos().size();
        vtaCliDTO.setCantidad_productos(cantidad);
        vtaCliDTO.setNombre_cliente(venta.getCliente().getNombre());
        vtaCliDTO.setApellido_cliente(venta.getCliente().getApellido());

        return vtaCliDTO;
    }
}
