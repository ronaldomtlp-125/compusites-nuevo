package com.compusites.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.compusites.patrones.BfF.ProductoAdminDTO;
import com.compusites.patrones.BfF.ProductoVendedorDTO;
import com.compusites.repository.ProductoRepository;

public class ProductoController {
	// BACKEND TO FRONT END
    @Autowired
    private ProductoRepository productoRepository;

    // Endpoint para ADMIN
    @GetMapping("/admin/productos")
    public List<ProductoAdminDTO> getProductosAdmin() {
        return productoRepository.findAll().stream().map(producto -> 
            new ProductoAdminDTO(
                producto.getNombre(), producto.getPrecio(), producto.getPrecioOferta(),
                producto.getCosto(), producto.getStock()
            )
        ).collect(Collectors.toList());
    }

    // Endpoint para VENDEDOR
    @GetMapping("/vendedor/productos")
    public List<ProductoVendedorDTO> getProductosVendedor() {
        return productoRepository.findAll().stream().map(producto -> 
            new ProductoVendedorDTO(
                producto.getNombre(), producto.getPrecio(), producto.getStock()
            )
        ).collect(Collectors.toList());
    }
}
