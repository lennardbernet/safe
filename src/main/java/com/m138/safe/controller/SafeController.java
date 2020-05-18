package com.m138.safe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SafeController {

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("password", "");
        return "/login";
    }

    @PostMapping("/login")
    public String postLoginPage(@RequestParam(value = "password", required = false) String password, Model model) {
        System.out.println(password);
        return "/login";
    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("newPassword", new Password());
        return "/dashboard";
    }

    @PostMapping("/dashboard")
    public String getDashboard(@RequestParam(value = "newPassword", required = false) Password newPassword, Model model) {
        System.out.println(newPassword.getPassword());
        return "/dashboard";
    }

}
