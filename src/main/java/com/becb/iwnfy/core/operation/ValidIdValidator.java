package com.becb.iwnfy.core.operation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidIdValidator implements ConstraintValidator<ValidId, String> {

	    @Override
	    public void initialize(ValidId constraintAnnotation) {

	    }

	    public boolean isValid(String value, ConstraintValidatorContext context) {
	        boolean valido = true;


	        System.out.println(value.toString());
	        System.out.println("Entrou na anotação");

	        return valido;
	    }



	

	
	
	
	
}
