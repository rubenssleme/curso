package br.com.cursojava2020.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursojava2020.curso.model.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
