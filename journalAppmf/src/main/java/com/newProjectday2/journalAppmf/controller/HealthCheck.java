package com.newProjectday2.journalAppmf.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HealthCheck {
      
    @GetMapping("/health-checking")
    public String healthCheck(){
     return "ok";
    }
    
}
