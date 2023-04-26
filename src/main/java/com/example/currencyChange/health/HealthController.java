package com.example.currencyChange.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/actuator")
public class HealthController {
    @GetMapping(path = "/actuator/health")
    public String healthCheck(){
        return "UP";
    }
}



