package com.example.core.repository;

import com.example.core.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RoleRepository extends JpaRepository<RoleUser, Long> {
    public Collection<RoleUser> findAllByName(String nameRole);
}
