package com.orbistech.ec3peredaalvino.service;

import com.orbistech.ec3peredaalvino.exception.ResourceNotFoundException;
import com.orbistech.ec3peredaalvino.model.Cliente;
import com.orbistech.ec3peredaalvino.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> findById(Integer id) {
        return Optional.ofNullable(clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existen registros de clientes con el id: " + id)));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        if (!clienteRepository.existsById(cliente.getId())) {
            throw new ResourceNotFoundException("No existen registros de clientes con el id: " + cliente.getId());
        }
        return clienteRepository.save(cliente);
    }

    public void deleteById(Integer id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("No existen registros de clientes con el id: " + id);
        }
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
