package com.luv2code.springcoredemo.common;

import java.util.concurrent.ForkJoinWorkerThread;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In contructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
