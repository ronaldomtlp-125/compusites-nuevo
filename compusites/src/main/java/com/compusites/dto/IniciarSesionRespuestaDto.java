package com.compusites.dto;

public class IniciarSesionRespuestaDto {
	private Long id;
	private String nombres;
    private String usuario;
    private String rol;
    
	public IniciarSesionRespuestaDto() {
		super();
	}
	public IniciarSesionRespuestaDto(Long id, String nombres, String usuario, String rol) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.usuario = usuario;
		this.rol = rol;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
}
