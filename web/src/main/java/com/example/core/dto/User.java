package com.example.core.dto;

import lombok.Data;

import java.util.Collection;

@Data
public class User {

    private Long id;

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordRepeat;
    private boolean enabled;

    private Collection<RoleUser> roles;
}
