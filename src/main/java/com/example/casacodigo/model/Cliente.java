package com.example.casacodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private @NotBlank @Email @Column(unique = true) String email;
	private @NotBlank String nome;
	private @NotBlank String sobrenome;
	private @NotBlank @Column(unique = true) String documento;
	private @NotBlank String endereco;
	private String complemento;
	private @NotNull @ManyToOne Pais pais;
	private @ManyToOne Estado estado;
	private @NotBlank String telefone;
	private @NotBlank String cep;

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@NotBlank String endereco, String complemento, @NotNull Pais pais, @NotBlank String telefone,
			@NotBlank String cep) {
		// TODO Auto-generated constructor stub
	}

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@NotBlank String endereco, String complemento, @NotNull Pais pais, @NotNull Estado estado,
			@NotBlank String telefone, @NotBlank String cep) {
				this.email = email;
				this.nome = nome;
				this.sobrenome = sobrenome;
				this.documento = documento;
				this.endereco = endereco;
				this.complemento = complemento;
				this.pais = pais;
				this.estado = estado;
				this.telefone = telefone;
				this.cep = cep;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", pais=" + pais + ", estado="
				+ estado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

}
