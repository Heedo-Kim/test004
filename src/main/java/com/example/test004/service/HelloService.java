package com.example.test004.service;

import com.example.test004.entity.Role;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {
    private final RoleService roleService;

    public void test0() {
        Role byId = roleService.findById(6L).get();
        byId.setUpdatedAt(LocalDateTime.now());
        roleService.update(byId);
    }
}
