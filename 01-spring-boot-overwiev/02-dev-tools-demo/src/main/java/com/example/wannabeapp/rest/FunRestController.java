package com.example.wannabeapp.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    @GetMapping("/teaminfo")
    public String getTeamInfo()
    {
        return "Coach: " + coachName + " Team name: " + teamName;
    }
    // tworzenie kontrolera dla GET
    @GetMapping("/")
    public String sayHello() {
        return "Oto ja";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run hard 15km!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your luck day!";
    }


}
