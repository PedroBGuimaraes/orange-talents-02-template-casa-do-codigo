package com.example.casacodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.casacodigo.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
	Optional<Autor> findByEmail(String email);
}
