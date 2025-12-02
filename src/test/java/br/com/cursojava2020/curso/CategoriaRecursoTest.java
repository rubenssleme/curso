package br.com.cursojava2020.curso;

import br.com.cursojava2020.curso.controller.CategoriaRecurso;
import br.com.cursojava2020.curso.model.entities.Categoria;
import br.com.cursojava2020.curso.service.CategoriaServico;
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
public class CategoriaRecursoTest {

    @Mock
    private CategoriaServico servico;

    @InjectMocks
    private CategoriaRecurso recurso;

    @Test
    void findAllReturnsListOfCategorias() {
        List<Categoria> categorias = List.of(new Categoria(1L, "Categoria 1"), new Categoria(2L, "Categoria 2"));
        when(servico.findAll()).thenReturn(categorias);

        ResponseEntity<List<Categoria>> response = recurso.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categorias, response.getBody());
    }

    @Test
    void findByIdReturnsCategoriaWhenIdExists() {
        Categoria categoria = new Categoria(1L, "Categoria 1");
        when(servico.findById(1L)).thenReturn(categoria);

        ResponseEntity<Categoria> response = recurso.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categoria, response.getBody());
    }

    @Test
    void findByIdThrowsExceptionWhenIdDoesNotExist() {
        when(servico.findById(99L)).thenThrow(new ResourceNotFoundException("Categoria not found"));

        assertThrows(ResourceNotFoundException.class, () -> recurso.findById(99L));
    }

//    @Test
//    void insertCreatesAndReturnsCategoria() {
//        Categoria categoria = new Categoria(null, "Nova Categoria");
//        Categoria savedCategoria = new Categoria(1L, "Nova Categoria");
//        when(servico.insert(categoria)).thenReturn(savedCategoria);
//
//        ResponseEntity<Categoria> response = recurso.insert(categoria);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(savedCategoria, response.getBody());
//        assertTrue(response.getHeaders().getLocation().toString().contains("/categorias/1"));
//    }
}