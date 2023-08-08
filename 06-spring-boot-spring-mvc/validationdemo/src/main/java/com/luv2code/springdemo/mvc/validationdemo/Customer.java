package com.luv2code.springdemo.mvc.validationdemo;

import com.luv2code.springdemo.mvc.validationdemo.validation.Coursecode;
import jakarta.validation.constraints.*;

public class Customer {

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters/digits")
    private String firstName;

    @Coursecode
    private String coursecode;
    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getPostalCode() {
        return PostalCode;
    }



    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    private String PostalCode;


    @NotNull(message = "is required")
    @Min(value=0, message = "must be greater than or equal to zero")
    @Max(value=10, message = "must be less than or equal to 10")
    private Integer freePasses;
    public Integer getFreePasses(){
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public Customer() {

    }





    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName = " ";
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
