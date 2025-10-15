package com.curso2020.curso.mapper;

import com.curso2020.curso.model.dto.UsuarioDTO;
import com.curso2020.curso.model.entities.Usuario;
import com.curso2020.curso.model.response.UsuarioResponse;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioResponse map(UsuarioDTO value);
    Usuario usuarioDtoToUsuario(UsuarioDTO usuarioDTO);
    List<UsuarioResponse> usuarioDtoToList(List<UsuarioDTO> usuario);
}
