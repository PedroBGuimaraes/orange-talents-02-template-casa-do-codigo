package com.example.casacodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.casacodigo.model.Estado;
import com.example.casacodigo.model.Pais;
import com.example.casacodigo.validator.ExistsId;

public class NovoEstadoDto {
	@NotBlank 
	private String nome;
	@NotNull @ExistsId(domainClass = Pais.class, fieldName = "id")
	private Integer idPais;
	
	public NovoEstadoDto(@NotBlank String nome, @NotBlank Integer idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public Integer getIdPais() {
		return idPais;
	}
	
	public String getNome() {
		return nome;
	}

	public Estado toModel(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, idPais);
		return new Estado(nome, pais);
	}
	
	
}
