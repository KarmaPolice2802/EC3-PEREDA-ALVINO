package com.orbistech.ec3peredaalvino.repository;

import com.orbistech.ec3peredaalvino.model.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Integer> {
}