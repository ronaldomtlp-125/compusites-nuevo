package com.compusites.service;

import java.util.List;
import java.util.Optional;

import com.compusites.dto.UsuarioRegistrarDto;
import com.compusites.model.Usuario;

public interface IUsuarioService {
	public Usuario buscarPorUsuario(String usuario);
	public List<Usuario> listaUsuarios();
	public Optional<Usuario> buscarPorId(Long id);
	public void eliminarPorId(Long id);
	public String cifrarContrasenia (String contrasenia);
	public boolean verificarContrasenia(String contraseniaEnviada, String contraseniaGuardadaHash);
	public void guardarUsuario(Usuario usuario);
	//REGISTRAR USUARIO
	public Usuario registrarUsuario(UsuarioRegistrarDto dto);
}
