package com.Rahahleh.fxAnalyzer.tools;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DecimalValidator implements ConstraintValidator<DecimalContraint, String> {
    @Override
    public void initialize(DecimalContraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null || s.isEmpty()){
            return false;
        }
        return isDecimal(s.trim());
    }
    public static boolean isDecimal(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
