package com.SpringBootFinalApp.completeApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {
    @GetMapping("/")
    public String getHome()
    {
        return "Hello world";
    }
}
