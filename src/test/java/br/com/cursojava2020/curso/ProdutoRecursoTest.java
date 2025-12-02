package br.com.cursojava2020.curso;

import br.com.cursojava2020.curso.controller.ProdutoRecurso;
import br.com.cursojava2020.curso.model.entities.Produto;
import br.com.cursojava2020.curso.service.ProdutoServico;
import br.com.cursojava2020.curso.service.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProdutoRecursoTest {

    @Mock
    private ProdutoServico servico;

    @InjectMocks
    private ProdutoRecurso recurso;

    @Test
    void findAllReturnsListOfProdutos() {
        List<Produto> produtos = List.of(new Produto(1L, "Produto 1"), new Produto(2L, "Produto 2"));
        when(servico.findAll()).thenReturn(produtos);

        ResponseEntity<List<Produto>> response = recurso.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produtos, response.getBody());
    }

    @Test
    void findByIdReturnsProdutoWhenIdExists() {
        Produto produto = new Produto(1L, "Produto 1");
        when(servico.findById(1L)).thenReturn(produto);

        ResponseEntity<Produto> response = recurso.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produto, response.getBody());
    }

    @Test
    void findByIdThrowsExceptionWhenIdDoesNotExist() {
        when(servico.findById(99L)).thenThrow(new ResourceNotFoundException("Produto not found"));

        assertThrows(ResourceNotFoundException.class, () -> recurso.findById(99L));
    }

//    @Test
//    void insertCreatesAndReturnsProduto() {
//        Produto produto = new Produto(2L, "Novo Produto");
//        Produto savedProduto = new Produto(1L, "Novo Produto");
//        when(servico.insert(produto)).thenReturn(savedProduto);
//
//        ResponseEntity<Produto> response = recurso.insert(produto);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(savedProduto, response.getBody());
//        assertTrue(response.getHeaders().getLocation().toString().contains("/produtos/1"));
//    }
}