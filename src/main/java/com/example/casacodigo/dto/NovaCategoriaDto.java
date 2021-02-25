package com.example.casacodigo.dto;

import javax.validation.constraints.NotBlank;

import com.example.casacodigo.model.Categoria;
import com.example.casacodigo.validator.UniqueValue;

public class NovaCategoriaDto {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	public void setNome(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public Categoria toModel() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return this.nome;
	}
	
}
