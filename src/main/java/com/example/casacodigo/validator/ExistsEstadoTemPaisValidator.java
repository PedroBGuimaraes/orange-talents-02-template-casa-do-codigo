package com.example.casacodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.casacodigo.repository.EstadoRepository;

public class ExistsEstadoTemPaisValidator implements ConstraintValidator<ExistsEstadoTemPais, Integer> {

	private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EstadoRepository estadoRepository;
	
	@Override
	public void initialize(ExistsEstadoTemPais params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		List<?> estadosBuscaPais = estadoRepository.findAll();
		
		
		return false;
	}

	
}