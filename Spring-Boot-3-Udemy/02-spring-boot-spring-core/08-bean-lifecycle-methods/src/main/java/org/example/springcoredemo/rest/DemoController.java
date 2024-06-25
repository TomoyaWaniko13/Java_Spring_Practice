package org.example.springcoredemo.rest;

import org.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach fristCoach;
    private Coach secondCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach firstCoach, @Qualifier("cricketCoach") Coach secondCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.fristCoach = firstCoach;
        this.secondCoach = secondCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return fristCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: " + (fristCoach == secondCoach);
    }
}
