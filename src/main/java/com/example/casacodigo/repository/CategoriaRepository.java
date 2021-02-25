package com.example.casacodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.casacodigo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	Optional<Categoria> findByNome(String nome);
}
