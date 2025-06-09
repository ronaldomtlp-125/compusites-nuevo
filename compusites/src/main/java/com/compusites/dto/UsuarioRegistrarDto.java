package com.compusites.dto;

public class UsuarioRegistrarDto {
	private String nombres;
	private String usuario;
	private String correo;
	private String contrasenia;
	private String rol;
	
	public UsuarioRegistrarDto() {
		super();
	}
	public UsuarioRegistrarDto(String nombres, String usuario, String correo, String contrasenia, String rol) {
		super();
		this.nombres = nombres;
		this.usuario = usuario;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
}
