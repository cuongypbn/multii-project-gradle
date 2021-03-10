package com.example.core.controller;

import com.example.core.dto.User;
import com.example.core.kafka.SendUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@AllArgsConstructor
public class loginController {
    private final SendUser sendUser;

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        log.warn("login user {}", user);
        sendUser.send("user", user);
        return "login";
    }
}
