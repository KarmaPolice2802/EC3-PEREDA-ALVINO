package com.orbistech.ec3peredaalvino.service;

import com.orbistech.ec3peredaalvino.exception.ResourceNotFoundException;
import com.orbistech.ec3peredaalvino.model.Pedido;
import com.orbistech.ec3peredaalvino.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Optional<Pedido> findById(Integer id) {
        return Optional.ofNullable(pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existen registros de pedidos con el id: " + id)));
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido update(Pedido pedido) {
        if (!pedidoRepository.existsById(pedido.getId())) {
            throw new ResourceNotFoundException("No existen registros de pedidos con el id: " + pedido.getId());
        }
        return pedidoRepository.save(pedido);
    }

    public void deleteById(Integer id) {
        if (!pedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("No existen registros de pedidos con el id: " + id);
        }
        pedidoRepository.deleteById(id);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
