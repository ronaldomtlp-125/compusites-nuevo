package com.compusites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compusites.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
