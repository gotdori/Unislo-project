package com.miniproject.unislo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    
    @GetMapping(value = "/")
    public String main(){
        return "index";
    }
}
