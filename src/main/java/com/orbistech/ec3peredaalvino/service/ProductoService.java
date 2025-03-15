package com.orbistech.ec3peredaalvino.service;

import com.orbistech.ec3peredaalvino.exception.ResourceNotFoundException;
import com.orbistech.ec3peredaalvino.model.Producto;
import com.orbistech.ec3peredaalvino.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Optional<Producto> findById(Integer id) {
        return Optional.ofNullable(productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existen registros de productos con el id: " + id)));
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto update(Producto producto) {
        if (!productoRepository.existsById(producto.getId())) {
            throw new ResourceNotFoundException("No existen registros de productos con el id: " + producto.getId());
        }
        return productoRepository.save(producto);
    }

    public void deleteById(Integer id) {
        if (!productoRepository.existsById(id)) {
            throw new ResourceNotFoundException("No existen registros de productos con el id: " + id);
        }
        productoRepository.deleteById(id);
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }
}
