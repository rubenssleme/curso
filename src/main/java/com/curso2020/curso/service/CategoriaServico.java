package com.curso2020.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso2020.curso.model.entities.Categoria;
import com.curso2020.curso.repository.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio repositorio;

	public List<Categoria> findAll() {
		return repositorio.findAll();

	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}

	public Categoria insert(Categoria obj) {
		return repositorio.save(obj);
	}
}
