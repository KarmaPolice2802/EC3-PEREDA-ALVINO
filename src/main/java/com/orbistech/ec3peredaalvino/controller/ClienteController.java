package com.orbistech.ec3peredaalvino.controller;

import com.orbistech.ec3peredaalvino.exception.ResourceNotFoundException;
import com.orbistech.ec3peredaalvino.model.Cliente;
import com.orbistech.ec3peredaalvino.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (!cliente.isPresent()) {
            throw new ResourceNotFoundException("No existen registros para el cliente con el id: " + id);
        }
        return ResponseEntity.ok(cliente.get());
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteService.save(cliente);
        return ResponseEntity.ok(savedCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        if (!clienteService.findById(id).isPresent()) {
            throw new ResourceNotFoundException("No existen registros para el cliente con el id: " + id);
        }
        cliente.setId(id);
        Cliente updatedCliente = clienteService.update(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        if (!clienteService.findById(id).isPresent()) {
            throw new ResourceNotFoundException("No existen registros para el cliente con el id: " + id);
        }
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }
}