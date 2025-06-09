package com.compusites.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compusites.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	//Mappear facil usuario por el usuario
	Optional<Usuario> findByUsuario(String usuario);
}
