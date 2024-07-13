package com.example.spring_boot_core_demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }


    public void doMyStartupStuff() {
        System.out.println("Bean " + getClass().getSimpleName() + " is ready to use.");
    }


    public void doMyCleanupStuff() {
        System.out.println("Bean: " + getClass().getSimpleName() + "is ready to delete");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 15minutes!";
    }
}
