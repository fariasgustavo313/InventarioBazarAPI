package com.farias.InventarioBazarAPI.controller;

import com.farias.InventarioBazarAPI.model.Cliente;
import com.farias.InventarioBazarAPI.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public String crearCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);
        return "Cliente creado con exito";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "Cliente eliminado con exito";
    }

    @PutMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id,
                                @RequestBody Cliente cliente) {
        clienteService.editarCliente(id, cliente);
        return "Cliente editado con exito";
    }

    @GetMapping("/{id}")
    public Cliente obtenercliente(@PathVariable Long id) {
        return clienteService.obtenerCliente(id);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
}
