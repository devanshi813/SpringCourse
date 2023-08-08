package com.udemy1.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestCOntroller {
    //expose "/" return "Hello world"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
}
