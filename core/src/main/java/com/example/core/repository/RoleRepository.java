package com.example.core.repository;

import com.example.core.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleUser, Long> {
}
