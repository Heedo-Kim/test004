package com.example.test004.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.test004.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
