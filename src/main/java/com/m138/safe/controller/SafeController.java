package com.m138.safe.controller;

import com.m138.safe.Password;
import com.m138.safe.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class SafeController {

    private PasswordService passwordService;
    private ArrayList<Password> allPasswords;

    @Autowired
    public SafeController(PasswordService passwordService) {
        allPasswords = new ArrayList<>();
        this.passwordService = passwordService;
    }
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        System.out.println("getMapping login");
        model.addAttribute("password", "");
        return "/login";
    }

    @PostMapping("/login")
    public String postLoginPage(@RequestParam(value = "password", required = false) String password, Model model) {
        System.out.println("postMapping login");
        System.out.println(password);
        //TODO db masterpasswort passwordService.login(password)
        return "/dashboard";
    }

    @GetMapping("/dashboard")
    public String getDashboardStatus(@RequestParam(value = "status", required = false) String status, Model model) {
        model.addAttribute("newPassword", new Password());
        if(status == null){
            return "/dashboard";
        }else{
            allPasswords.add(new Password("lennard","1234"));
            //TODO db werte laden passwordService.decrypt() : ArrayList<Password>
            model.addAttribute("allPasswords", allPasswords);
        }
        System.out.println("getMapping dashboard");
        return "/dashboard";
    }

    @PostMapping("/dashboard")
    public String getDashboard(@ModelAttribute Password password,Model model) {
        System.out.println("postMapping dashboard");
        System.out.println(password.getPassword());
        //TODO db passwort abspeichern passwordService.encrypt(Password password) : void
        //TODO neu erstelletes passwort anzeigen
        return "/dashboard";
    }

}
