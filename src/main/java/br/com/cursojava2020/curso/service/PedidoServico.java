package br.com.cursojava2020.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursojava2020.curso.model.entities.Pedido;
import br.com.cursojava2020.curso.repository.PedidoRepositorio;
@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio  pedidoRepositorio;
	
	public List<Pedido> findAll(){
		return pedidoRepositorio.findAll();
		
	}
	
	public Pedido findById(Long id ) {
		Optional<Pedido> obj = pedidoRepositorio.findById(id);
		return obj.get();
	}
}
