package com.miniproject.unislo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {
    
    @GetMapping(value = "/")
    public String main(){
        return "gimochi";
    }
}
