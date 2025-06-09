package com.compusites.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.compusites.dto.UsuarioRegistrarDto;
import com.compusites.model.Usuario;
import com.compusites.repository.IUsuarioRepository;
import com.compusites.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private final IUsuarioRepository usuarioRepo;
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	public UsuarioServiceImpl(IUsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {
		this.usuarioRepo = usuarioRepo;
		this.passwordEncoder = passwordEncoder;
	}

	//Buscar usuario por su nombre de usuario
	@Override
	public Usuario buscarPorUsuario(String usuario) {
		return usuarioRepo.findByUsuario(usuario).orElse(null);
	}

	//Mostrar todos los usuarios
	@Override
	public List<Usuario> listaUsuarios() {
		return usuarioRepo.findAll();
	}
	
	//Buscar usuario por ID
	@Override
	public Optional<Usuario> buscarPorId(Long id) {
	    return usuarioRepo.findById(id);
	}
	
	//Eliminar usuario por ID
	@Override
	public void eliminarPorId(Long id) {
	    usuarioRepo.deleteById(id);
	}
	
	//Cifrar contrasenias para iniciar sesion, registrar y cambiar contrasenia
	@Override
	public String cifrarContrasenia(String contrasenia) {
		return passwordEncoder.encode(contrasenia);
	}

	//Verificar contrasenias
	@Override									// sin hash					//con hash
	public boolean verificarContrasenia(String contraseniaEnviada, String contraseniaGuardadaHash) {
		return passwordEncoder.matches(contraseniaEnviada, contraseniaGuardadaHash);
	}

	// Guardar Usuario
	@Override
	public void guardarUsuario(Usuario usuario) {
		usuarioRepo.save(usuario);
		
	}

	
	
	//REGISTRAR USUARIO
	@Override
	public Usuario registrarUsuario(UsuarioRegistrarDto dto) {
		Usuario usuario = new Usuario();
		usuario.setNombres(dto.getNombres());
		usuario.setUsuario(dto.getUsuario());
		usuario.setCorreo(dto.getCorreo());
		usuario.setContrasenia(cifrarContrasenia(dto.getContrasenia()));
		usuario.setRol(dto.getRol());
		
		return usuarioRepo.save(usuario);
	}
	
}
