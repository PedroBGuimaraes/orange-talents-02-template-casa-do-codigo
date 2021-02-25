package com.example.casacodigo.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casacodigo.dto.NovoClienteDto;
import com.example.casacodigo.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String postNovoCliente(@RequestBody @Valid NovoClienteDto novoClienteDto) {
		Cliente novoCliente = novoClienteDto.toModel(manager);
		manager.persist(novoCliente);
		return novoCliente.toString();
	}
	
}
