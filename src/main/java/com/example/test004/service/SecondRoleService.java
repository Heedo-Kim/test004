package com.example.test004.service;

import com.example.test004.config.DatabaseContextHolder;
import com.example.test004.entity.Role;
import com.example.test004.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecondRoleService {
    private final RoleRepository roleRepository;

    @Transactional
    public void update(Role role) {
        logType();
        roleRepository.save(role);
    }

    private void logType() {
        log.info("logging context db Type: {}", DatabaseContextHolder.getDbType());
    }
}
