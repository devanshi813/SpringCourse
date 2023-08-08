package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  DemoController {

    //define the private field for the dependency
    private Coach myCoach;

    //define a contructor for the dependency injection
    @Autowired //tells spring to inject the dependency, for one its optional
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/DailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
