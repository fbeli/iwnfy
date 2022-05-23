package com.becb.iwnfy.core.operation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidIdValidator.class })
public @interface ValidId {

	String message() default "Valor  inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
