package com.fernandez.cars.validation;

import org.apache.commons.lang3.StringUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class FirstLetterUpperCaseValidator implements ConstraintValidator<FirstLetterUperCaseStr, String> {

    private String regex = ".*[A-Z].*";

    @Override
    public boolean isValid(String str, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(str))
            return true;

        Pattern pat = Pattern.compile(regex);
        return pat.matcher(str).matches();
    }

}
