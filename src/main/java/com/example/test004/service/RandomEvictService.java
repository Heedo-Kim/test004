package com.example.test004.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class RandomEvictService {
    @CacheEvict(value = "randomService", allEntries = true)
    public void clearRandomService() {

    }
}
