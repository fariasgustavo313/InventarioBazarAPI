package com.farias.InventarioBazarAPI.service;

import com.farias.InventarioBazarAPI.model.Cliente;
import com.farias.InventarioBazarAPI.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void crearCliente(Cliente cliente) {
        try {
            if (cliente.getNombre().isEmpty() || cliente.getApellido().isEmpty() || (cliente.getDni().isEmpty() && cliente.getDni().length() < 6)) {
                throw new Exception("Los campos no pueden estar vacios y/o el dni no puede tener menos de 6 digitos");
            } else {
                clienteRepository.save(cliente);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public void editarCliente(Long id, Cliente cliente) {
        try {
            Cliente cli = clienteRepository.findById(id).orElse(null);
            if (cliente.getNombre().isEmpty() || cliente.getApellido().isEmpty() || (cliente.getDni().isEmpty() && cliente.getDni().length() < 6)) {
                throw new Exception("Los campos no pueden estar vacios y/o el dni no puede tener menos de 6 digitos");
            } else {
                cli.setNombre(cliente.getNombre());
                cli.setApellido(cliente.getApellido());
                cli.setDni(cliente.getDni());
                clienteRepository.save(cli);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Cliente obtenerCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
