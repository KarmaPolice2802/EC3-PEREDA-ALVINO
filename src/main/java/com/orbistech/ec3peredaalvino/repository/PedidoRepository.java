package com.orbistech.ec3peredaalvino.repository;

import com.orbistech.ec3peredaalvino.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}