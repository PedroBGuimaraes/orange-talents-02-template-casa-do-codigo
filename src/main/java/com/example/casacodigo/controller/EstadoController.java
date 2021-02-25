package com.example.casacodigo.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casacodigo.dto.NovoEstadoDto;
import com.example.casacodigo.model.Estado;
import com.example.casacodigo.validator.EstadoJaCadastradoNessePaisValidator;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	private EntityManager manager;
	@Autowired
	private EstadoJaCadastradoNessePaisValidator estadoJaCadastradoNessePaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoJaCadastradoNessePaisValidator);
	}
	
	@PostMapping
	@Transactional
	public String postNovoEstado(@RequestBody @Valid NovoEstadoDto novoEstadoDto) {
		Estado novoEstado = novoEstadoDto.toModel(manager);
		manager.persist(novoEstado);
		return novoEstado.toString();
	}
}
