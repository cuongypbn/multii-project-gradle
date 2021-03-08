package com.example.core.controller;


import com.example.core.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    @RequestMapping("/login")
    public String viewIndex() {
        return "login";
    }

    @RequestMapping("/home")
    public String viewHome() {
        return "index";
    }

    @RequestMapping("/admin")
    public String viewAdmin() {
        return "about";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping("/logout")
    public String logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "/login";
    }
}
