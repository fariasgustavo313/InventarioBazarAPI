package com.farias.InventarioBazarAPI.service;

import com.farias.InventarioBazarAPI.model.Cliente;
import com.farias.InventarioBazarAPI.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public void editarCliente(Long id, Cliente cliente) {
        Cliente cli = clienteRepository.findById(id).orElse(null);
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
        cli.setDni(cliente.getDni());

        clienteRepository.save(cli);
    }
}
