package com.curso2020.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso2020.curso.model.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
