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

import com.example.casacodigo.dto.NovoAutorDto;
import com.example.casacodigo.model.Autor;
import com.example.casacodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	@Transactional
	public String postNovoAutor(@RequestBody @Valid NovoAutorDto novoAutorDto) {
		Autor novoAutor = novoAutorDto.toModel();
		autorRepository.save(novoAutor);
		return novoAutor.toString();
	}
	
	@GetMapping
	public ResponseEntity<List<Autor>> getListaAutores(){
		List<Autor> autores = autorRepository.findAll();
		return ResponseEntity.ok(autores);
	}
}
