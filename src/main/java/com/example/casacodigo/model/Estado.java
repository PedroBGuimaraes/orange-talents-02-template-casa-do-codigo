package com.example.casacodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {
        "nome",
        "pais_id"
}))
public class Estado {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String nome;
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public Estado() {
		
	}
	
	public Estado(@NotBlank String nome, @NotBlank Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public Pais getPais() {
		return pais;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}
	
}
