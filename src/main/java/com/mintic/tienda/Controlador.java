package com.mintic.tienda;

//import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.dto.VentaCliente;
import com.mintic.tienda.entities.TipoDocumento;
import com.mintic.tienda.entities.Usuario;
import com.mintic.tienda.repositories.ITipoDocumento;
import com.mintic.tienda.servicio.IUsuarioService;
import com.mintic.tienda.servicio.IVentaService;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

/*@RestController permitir el manejo de solicitudes HTTP  get post put delete
 * */
@RestController
@RequestMapping("/tiendagenerica/v1")
public class Controlador {

	/*
	 * inyectamos el la iterface del servicio para acceder a los metodos del negocio
	 **/
	@Autowired
	IUsuarioService iUsuario;

	
	@Autowired
	IVentaService iVenteService;
	
	
	
	/*
	 * inyectamos el la iterface del repositirio OJO lo hice directamento porque no
	 * es necesaria ninguna logica de negocio solo necesito el listado de tipos de
	 * documento si quieren pueden hacerlo directamente con el repositorio de
	 * usuario y no tendrian que crear el servicio (pero no es la mejor forma de
	 * realzarlo)
	 **/
	@Autowired
	ITipoDocumento iTipoDocumento;

	/*
	 * @CrossOrigin indica desde que sitios se van a realizar peticiones
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/loginclient") // ruta del servicio desde el front deben direccionar a esta ruta
	public int login(@RequestBody LoginDto usuario) {
		
		int responseLogin = iUsuario.login(usuario);
		return responseLogin;

	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/loginusuario") // ruta del servicio desde el front deben direccionar a esta ruta
	public Usuario loginusuario(@RequestBody LoginDto usuario) {

		Usuario responseLogin = iUsuario.loginUsuario(usuario);

		//System.out.println(getJWTToken(usuario.getNombreUsuario()));
		
		return responseLogin;

	}
	
	
	/*private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}*/
	
	
	
	
	
	
	

	@PostMapping("/login") // ruta del servicio desde el front deben direccionar a esta ruta
	public ResponseEntity<?> loginCliente(@RequestBody LoginDto usuario) {
		return iUsuario.ingresar(usuario);

	}

	@PostMapping("/usuarios")
	public Usuario usuario(@RequestBody UsuarioDto usuarioDto) {

		return iUsuario.nuevoUsuario(usuarioDto);
	}
	
	@PostMapping("/buscarusuario")
	public Usuario buscarUsuario(@RequestBody UsuarioDto usuarioDto) {
		
		return iUsuario.buscarUsuarioPorNumero(usuarioDto.getNumeroDocumento());
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
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
	
	
	@GetMapping("/reporteVenta")
	public List<VentaCliente>reporteVenta(){
		
		return iVenteService.reporteVenta();
	}
	

}
