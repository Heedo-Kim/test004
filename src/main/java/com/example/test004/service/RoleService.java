package com.example.test004.service;

import com.example.test004.annotation.Custom;
import com.example.test004.config.DatabaseContextHolder;
import com.example.test004.entity.Role;
import com.example.test004.repository.RoleRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Role> findAll() {
        logType();
        return roleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Role> findById(Long id) {
        logType();
        return roleRepository.findById(id);
    }

    @Transactional
    public void update(Role role) {
        logType();
        roleRepository.save(role);
    }

    private void logType() {
        log.info("logging context db Type: {}", DatabaseContextHolder.getDbType());
    }
}
