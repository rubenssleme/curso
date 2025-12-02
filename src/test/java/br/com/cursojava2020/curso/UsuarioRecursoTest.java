package br.com.cursojava2020.curso;

import br.com.cursojava2020.curso.controller.UsuarioRecurso;
import br.com.cursojava2020.curso.model.entities.Usuario;
import br.com.cursojava2020.curso.service.UsuarioServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioRecursoTest {

    @Mock
    private UsuarioServico usuarioServico;

    @InjectMocks
    private UsuarioRecurso usuarioRecurso;

    @Test
    void findAllShouldReturnListOfUsuariosWhenUsuariosExist() {
        List<Usuario> usuarios = List.of(new Usuario(1L, "User1", "user1@example.com"), new Usuario(2L, "User2", "user2@example.com"));
        when(usuarioServico.findAll()).thenReturn(usuarios);

        ResponseEntity<List<Usuario>> response = usuarioRecurso.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarios, response.getBody());
        verify(usuarioServico, times(1)).findAll();
    }

    @Test
    void findAllShouldReturnEmptyListWhenNoUsuariosExist() {
        when(usuarioServico.findAll()).thenReturn(List.of());

        ResponseEntity<List<Usuario>> response = usuarioRecurso.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
        verify(usuarioServico, times(1)).findAll();
    }
}