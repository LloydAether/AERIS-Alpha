package com.aeris.service;

import com.aeris.domain.Cliente;
import com.aeris.persistence.repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService() {
        repository = new ClienteRepository();
    }

    public List<Cliente> listarClientes() {
        return repository.listar();
    }

    public List<Cliente> buscarClientes(String texto) {

        if (texto == null || texto.isBlank()) {
            return listarClientes();
        }

        return repository.buscar(texto);

    }

}