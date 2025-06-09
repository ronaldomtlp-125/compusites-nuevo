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
public class Producto {
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
}
