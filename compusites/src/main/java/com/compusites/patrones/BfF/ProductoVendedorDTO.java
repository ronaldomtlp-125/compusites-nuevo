package com.compusites.patrones.BfF;

public class ProductoVendedorDTO {
	private String nombre;
    private Double precio;
    private Integer stock;
    
	public ProductoVendedorDTO(String nombre, Double precio, Integer stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
    
    
}
