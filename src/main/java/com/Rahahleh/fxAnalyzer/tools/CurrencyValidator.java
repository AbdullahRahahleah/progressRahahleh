package com.Rahahleh.fxAnalyzer.tools;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class CurrencyValidator implements ConstraintValidator<Currency, String> {

    private static final Set<String> CURRENCY_CODES = new HashSet<>();

    static {
            for(CurrencyEnum currencyEnum:CurrencyEnum.values()) {
                CURRENCY_CODES.add(currencyEnum.name());
            }
    }

    @Override
    public void initialize(Currency constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && CURRENCY_CODES.contains(value.toUpperCase());
    }
}

