package com.example.core.controller;

import com.example.core.dto.UserDto;
import com.example.core.entity.RoleUser;
import com.example.core.entity.User;
import com.example.core.repository.RoleRepository;
import com.example.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserDto userDto;

    @PostMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        User userNew = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Collection<RoleUser> roleUsers = roleRepository.findAllByName("USER");
        userNew.setUserId("User_" + userDto.getCountUser());

        userNew.setFirstName(user.getFirstName());

        userNew.setLastName(user.getFirstName());

        userNew.setEmail(user.getEmail());
        userNew.setEnabled(true);
        if (user.getPassword().equals(user.getPasswordRepeat())) {
            userNew.setPassword(passwordEncoder.encode(user.getPassword()));
            userNew.setPasswordRepeat(passwordEncoder.encode(user.getPasswordRepeat()));
        } else {
            throw new SecurityException();
        }
        userNew.setRoles(roleUsers);
        userRepository.save(userNew);
        log.warn("Create a user: {}", userNew);
        return "register";
    }


}
