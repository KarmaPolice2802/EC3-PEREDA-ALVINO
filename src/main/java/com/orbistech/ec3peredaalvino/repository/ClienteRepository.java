package com.orbistech.ec3peredaalvino.repository;

import com.orbistech.ec3peredaalvino.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}