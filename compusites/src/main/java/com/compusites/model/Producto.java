package com.compusites.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements IElementoCatalogo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private double precio;
	private double precioOferta;
	private double costo;
	private int stock;
	private String rucProveedor;
	private String rutaImg;
	private String urlFabricante;
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonBackReference(value = "producto-categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    @JsonBackReference(value = "producto-marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonBackReference(value = "producto-tag")
    private Tag tag;

	public Producto() {
		super();
	}

	public Producto(Long id, String nombre, double precio, double precioOferta, double costo, int stock,
			String rucProveedor, String rutaImg, String urlFabricante, Categoria categoria, Marca marca, Tag tag) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.precioOferta = precioOferta;
		this.costo = costo;
		this.stock = stock;
		this.rucProveedor = rucProveedor;
		this.rutaImg = rutaImg;
		this.urlFabricante = urlFabricante;
		this.categoria = categoria;
		this.marca = marca;
		this.tag = tag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRucProveedor() {
		return rucProveedor;
	}

	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}

	public String getRutaImg() {
		return rutaImg;
	}

	public void setRutaImg(String rutaImg) {
		this.rutaImg = rutaImg;
	}

	public String getUrlFabricante() {
		return urlFabricante;
	}

	public void setUrlFabricante(String urlFabricante) {
		this.urlFabricante = urlFabricante;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	//COMPOSITE
	@Override
	public void mostrarContenido(String prefijo) {
		System.out.println(prefijo + "Producto: " + nombre);
		
	}
}
