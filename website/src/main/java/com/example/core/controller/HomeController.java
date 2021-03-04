package com.example.core.controller;


import com.example.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String viewIndex() {
        return "login";
    }

    @RequestMapping("/home")
    public String viewHome() {
        return "about";
    }

}
