package com.luv2code.springdemo.mvc.validationdemo.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CourseCodeContraintValidator implements ConstraintValidator<Coursecode, String> {

    private String coursePrefix;

    @Override
    public void initialize(Coursecode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theconstraintValidatorContext) {

        boolean result = false;
        if(theCode!=null)
        {
            theCode.startsWith(coursePrefix);
        }else{
            return true;
        }
        
        return result;
    }
}
