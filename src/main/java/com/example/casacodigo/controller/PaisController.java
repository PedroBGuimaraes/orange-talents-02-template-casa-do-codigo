package com.example.casacodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casacodigo.dto.NovoPaisDto;
import com.example.casacodigo.model.Pais;
import com.example.casacodigo.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	public String postNovoPais(@RequestBody @Valid NovoPaisDto novoPaisDto) {
		Pais novoPais = novoPaisDto.toModel();
		paisRepository.save(novoPais);
		return novoPais.toString();
	}
	
	@GetMapping
	public ResponseEntity<?> getListaPaises(){
		List<Pais> paises = paisRepository.findAll();
		return ResponseEntity.ok(paises);
	}
}
