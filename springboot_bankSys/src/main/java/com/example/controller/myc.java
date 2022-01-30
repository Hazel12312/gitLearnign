package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myc {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login/{l}")
    public String login(@PathVariable String l){
        System.out.println("l"+l);
        return "login";
    }

    @GetMapping("/adminLogin")
    public String adminLogin(){
        return "adminLogin";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

}
