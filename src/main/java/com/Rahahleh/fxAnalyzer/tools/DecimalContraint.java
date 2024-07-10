package com.Rahahleh.fxAnalyzer.tools;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DecimalValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface DecimalContraint {
    String message() default "Invalid Decimal number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
