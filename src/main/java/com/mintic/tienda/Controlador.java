package com.mintic.tienda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.TipoDocumento;
import com.mintic.tienda.entities.Usuario;
import com.mintic.tienda.repositories.ITipoDocumento;
import com.mintic.tienda.servicio.IUsuarioService;

@RestController
public class Controlador {

	@Autowired
	IUsuarioService iUsuario;

	@Autowired
	ITipoDocumento iTipoDocumento;

	@CrossOrigin(origins = { "http://localhost:8080" })
	@PostMapping("/loginclient")
	public int login(@RequestBody LoginDto usuario) {

		int responseLogin = iUsuario.login(usuario);

		return responseLogin;

	}

	@PostMapping("/usuarios")
	public Usuario usuario(@RequestBody UsuarioDto usuarioDto) {

		return iUsuario.nuevoUsuario(usuarioDto);
	}

	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {

		return iUsuario.getUsuarios();
	}

	@GetMapping("/usuarios/{id}")
	public Usuario buscarUsuarioId(@PathVariable Long id) {
		return iUsuario.buscarUsuario(id);
	}

	@DeleteMapping("/usuarios/{id}")
	public int eliminarUsuario(@PathVariable Long id) {

		return iUsuario.borrarUsuario(id);
	}

	@GetMapping("/tipodocumento")
	public List<TipoDocumento> listarTipoDocumento() {

		return (List<TipoDocumento>) iTipoDocumento.findAll();
	}

}
