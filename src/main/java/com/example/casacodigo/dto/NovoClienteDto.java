package com.example.casacodigo.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.example.casacodigo.model.Cliente;
import com.example.casacodigo.model.Estado;
import com.example.casacodigo.model.Pais;
import com.example.casacodigo.validator.CpfOrCnpj;
import com.example.casacodigo.validator.ExistsId;
import com.example.casacodigo.validator.UniqueValue;

public class NovoClienteDto {
	@NotBlank @Email @UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@CpfOrCnpj @UniqueValue(domainClass = Cliente.class, fieldName = "documento") @NotBlank
	private String documento;
	@NotBlank
	private String endereco;
	private String complemento;
	@NotNull @ExistsId(domainClass = Pais.class, fieldName = "id")
	private Integer idPais;
	
	private Integer idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	public NovoClienteDto(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, String complemento, @NotBlank Integer idPais, Integer idEstado,
			@NotBlank String telefone, @NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Cliente toModel(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, idPais);
		List<Estado> buscaEstados = manager.createNativeQuery("Select * from estado where estado.pais_id='"+idPais+"'").getResultList();
		if(buscaEstados.isEmpty()) {
			Assert.isTrue(idEstado==null, "Esse estado não está linkado nesse País ou não existe");
			return new Cliente(email, nome, sobrenome, documento, endereco, complemento, pais, telefone, cep);
		}
		System.out.println("IdEstado: "+idEstado);
		Assert.isTrue(idEstado!=null, "Esse País tem um estado, selecione um");
		
		@NotNull Estado estado = manager.find(Estado.class, idEstado);
		
		Assert.isTrue(estado.getPais().getId()==idPais, "Esse estado não está linkado nesse País");
		
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, pais, estado, telefone, cep);
	}
}
