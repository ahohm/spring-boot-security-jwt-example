package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "All users";
    }

    @GetMapping("/user")
    public String user(){
        return "USER & ADMIN roles";
    }

    @GetMapping("/admin")
    public String dashboard(){
        return "Only ADMIN roles";
    }

}
