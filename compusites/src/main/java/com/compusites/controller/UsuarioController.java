package com.compusites.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compusites.dto.IniciarSesionRespuestaDto;
import com.compusites.dto.IniciarSesionSolicitudDto;
import com.compusites.dto.UsuarioRegistrarDto;
import com.compusites.model.Usuario;
import com.compusites.service.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired
	private final IUsuarioService usuarioService;
	
	public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
	
	//Ver lista de usuarios
	@GetMapping("/lista")
	public List<Usuario> listar() {
		return usuarioService.listaUsuarios();
	}
	
	//Borrar usuario
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
		Optional<Usuario> usuario = usuarioService.buscarPorId(id);
		
		if(!usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro con ID " + id + " no fue encontrado");
		}
		
		usuarioService.eliminarPorId(id);
		return ResponseEntity.ok("Registro eliminado correctamente");
	}
	
	
	
	//REGISTRAR USUARIO
	/*
	@PostMapping("/registrar")
	public Usuario registrarUsuario(@RequestBody UsuarioRegistrarDto dto) {
		
		
		return usuarioService.registrarUsuario(dto);
	}*/
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioRegistrarDto dto) {
		Usuario usuario = usuarioService.buscarPorUsuario(dto.getUsuario());
		
		if(usuario != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de usuario '" + dto.getUsuario() + "' ya existe en el sistema, elija otro");
		}
		
		usuarioService.registrarUsuario(dto);
		return ResponseEntity.ok("Usuario creado correctamente");
	}
	
	//INICIAR SESION USUARIO
	@PostMapping("/iniciar-sesion")
	public ResponseEntity<?> iniciarSesion (@RequestBody IniciarSesionSolicitudDto iSSolicitudDto){
		Usuario usuario = usuarioService.buscarPorUsuario(iSSolicitudDto.getUsuario());
		//verificar correo
		if(usuario == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
		}
		//verificar contrasenia
		if(!usuarioService.verificarContrasenia(iSSolicitudDto.getContrasenia(), usuario.getContrasenia())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
		}
		//si usuario y contra estan bien, enviar datos de usuario logeado para el localhost
		IniciarSesionRespuestaDto iSRespuestaDto = new IniciarSesionRespuestaDto(usuario.getId(), usuario.getNombres(), usuario.getUsuario(), usuario.getRol());
		return ResponseEntity.ok(iSRespuestaDto);
	}
}
