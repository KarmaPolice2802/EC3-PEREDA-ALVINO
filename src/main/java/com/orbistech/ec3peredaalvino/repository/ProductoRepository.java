package com.orbistech.ec3peredaalvino.repository;

import com.orbistech.ec3peredaalvino.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}