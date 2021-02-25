package com.example.casacodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.casacodigo.dto.NovoEstadoDto;
import com.example.casacodigo.model.Estado;

@Component
public class EstadoJaCadastradoNessePaisValidator implements Validator{
	
	@Autowired
	private EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return NovoEstadoDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		NovoEstadoDto novoEstadoDto = (NovoEstadoDto) target;
		
		// Valida se tem esse Estado nesse pais selecionado
		List<Estado> buscaEstados = manager.createNativeQuery("Select * from estado where estado.nome='"+novoEstadoDto.getNome()+"' and estado.pais_id='"+novoEstadoDto.getIdPais()+"'").getResultList();
		Assert.isTrue(buscaEstados.isEmpty(), "Esse estado já está cadastrado nesse País");
		
	}

}
