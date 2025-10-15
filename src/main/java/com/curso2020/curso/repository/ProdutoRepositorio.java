package com.curso2020.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso2020.curso.model.entities.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
