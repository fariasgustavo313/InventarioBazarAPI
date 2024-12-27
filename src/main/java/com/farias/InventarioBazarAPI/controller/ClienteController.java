package com.farias.InventarioBazarAPI.controller;

import com.farias.InventarioBazarAPI.model.Cliente;
import com.farias.InventarioBazarAPI.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Crear un usuario", description = "Permite crear un nuevo usuario")
    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente")
    @PostMapping("/crear")
    public String crearCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);
        return "Cliente creado con exito";
    }

    @Operation(summary = "Eliminar un usuario", description = "Permite eliminar un usuario existente")
    @ApiResponse(responseCode = "204", description = "Usuario eliminado exitosamente")
    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "Cliente eliminado con exito";
    }

    @Operation(summary = "Editar un usuario", description = "Permite editar un usuario existente")
    @ApiResponse(responseCode = "200", description = "Usuario editado exitosamente")
    @PutMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id,
                                @RequestBody Cliente cliente) {
        clienteService.editarCliente(id, cliente);
        return "Cliente editado con exito";
    }

    @Operation(summary = "Obtener un usuario", description = "Permite obtener un usuario por ID")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @GetMapping("/{id}")
    public Cliente obtenercliente(@PathVariable Long id) {
        return clienteService.obtenerCliente(id);
    }

    @Operation(summary = "Obtener lista de usuarios", description = "Permite obtener todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Operacion exitosa")
    @ApiResponse(responseCode = "404", description = "Usuarios no encontrados")
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
}
