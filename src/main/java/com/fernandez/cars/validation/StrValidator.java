package com.fernandez.cars.validation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class StrValidator implements ConstraintValidator<ValidStr, String> {
    private String regex = "/^[A-Z]+$/";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(email))
            return false;

        Pattern pat = Pattern.compile(regex);
        return pat.matcher(email).matches();
    }

}
