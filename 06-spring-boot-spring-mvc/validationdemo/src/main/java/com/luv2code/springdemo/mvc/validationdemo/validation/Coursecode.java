package com.luv2code.springdemo.mvc.validationdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeContraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Coursecode {

    // define default course code
    public String value() default "LUV";

    // define defaault error message
    public String message() default "must start with LUV";

    // define default groups
    public Class<?>[] groups() default{};

    // deifne default payloads
    public Class<? extends Payload>[] payload() default{};


}
