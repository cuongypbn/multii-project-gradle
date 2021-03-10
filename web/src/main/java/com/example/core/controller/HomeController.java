package com.example.core.controller;


import com.example.core.dto.User;
import com.example.core.kafka.Receiver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final Receiver receiver;

    @RequestMapping("/")
    public String viewIndex(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/home")
    public String viewHome() throws InterruptedException {
        receiver.latch.wait(10,10);

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
        return "/login";
    }
}
