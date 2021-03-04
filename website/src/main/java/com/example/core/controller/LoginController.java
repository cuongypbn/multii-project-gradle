package com.example.core.controller;

import com.example.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final UserRepository userRepository;

    @PostMapping("/login")
    public String login(Model model) {
        model.getAttribute("User");
        System.out.println("user");
        return "login";
    }
}
