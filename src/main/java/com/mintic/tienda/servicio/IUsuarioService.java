package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.Usuario;

public interface IUsuarioService {

	int login(LoginDto usuarioDto);

	List<Usuario> getUsuarios();

	Usuario nuevoUsuario(UsuarioDto usuarioDto);

	Usuario buscarUsuario(Long id);

	int borrarUsuario(Long id);

}
