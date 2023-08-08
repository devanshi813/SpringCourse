package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component //marks the class for spring beans and makes it available for dependency injection
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return "Practice Fast bowling for 15 minutes :)";
    }
}
