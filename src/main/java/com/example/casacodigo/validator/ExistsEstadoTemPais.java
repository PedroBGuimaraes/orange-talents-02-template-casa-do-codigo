package com.example.casacodigo.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { ExistsEstadoTemPaisValidator.class })
@Target({ ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface ExistsEstadoTemPais {

	String message() default "{com.deveficiente.beanvalidation.existsid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String fieldName();

	Class<?> domainClass();
}