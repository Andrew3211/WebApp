package com.rudnev.task4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main {

    @GetMapping("/login")
    public String login() {
        return "login_view";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
