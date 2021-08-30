package com.fernandez.cars.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, ANNOTATION_TYPE, TYPE_USE })
@Constraint(validatedBy = FirstLetterUpperCaseValidator.class)
public @interface FirstLetterUperCaseStr {

    String message() default "First letter uppercase";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
