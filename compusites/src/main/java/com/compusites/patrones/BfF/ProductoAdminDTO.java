package com.compusites.patrones.BfF;

public class ProductoAdminDTO {
	private String nombre;
	private double precio;
	private double precioOferta;
	private double costo;
	private int stock;
	public ProductoAdminDTO(String nombre, double precio, double precioOferta, double costo, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.precioOferta = precioOferta;
		this.costo = costo;
		this.stock = stock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPrecioOferta() {
		return precioOferta;
	}
	public void setPrecioOferta(double precioOferta) {
		this.precioOferta = precioOferta;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
    
}
