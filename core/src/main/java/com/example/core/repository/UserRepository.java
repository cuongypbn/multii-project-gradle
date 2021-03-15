package com.example.core.repository;

import com.example.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    public User findAllByEmail(String Email);
}
