package com.example.casacodigo.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casacodigo.dto.NovaCategoriaDto;
import com.example.casacodigo.model.Categoria;
import com.example.casacodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	@Transactional
	public String postNovaCategoria(@RequestBody @Valid NovaCategoriaDto novaCategoriaDto) {
		Categoria novaCategoria = novaCategoriaDto.toModel();
		categoriaRepository.save(novaCategoria);
		return novaCategoria.toString();
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getListaCategoria(){
		List<Categoria> categorias = categoriaRepository.findAll();
		return ResponseEntity.ok(categorias);
	}
	
}
