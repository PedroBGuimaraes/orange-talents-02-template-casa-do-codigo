package com.example.casacodigo.dto;

import javax.validation.constraints.NotBlank;

import com.example.casacodigo.model.Pais;
import com.example.casacodigo.validator.UniqueValue;

public class NovoPaisDto {
	@NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(nome);
	}
}
