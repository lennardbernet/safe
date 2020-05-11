package com.m138.safe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SafeController {

    @GetMapping("/login")
    public String getLoginPage(Model model) {

        return "/login";
    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {

        return "/dashboard";
    }

}
