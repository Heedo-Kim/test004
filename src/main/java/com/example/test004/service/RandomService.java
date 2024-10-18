package com.example.test004.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "randomService")
@RequiredArgsConstructor
public class RandomService {
    private final CacheManager cacheManager;
    @Cacheable
    public String cacheTest(String id) {
        return id + (Math.random()*100);
    }

    @Cacheable(value = "test2")
    public String cacheNameTest(String id) {
        return id + (Math.random()*1000);
    }

    public List<String> fetchAllCacheNames() {
        return cacheManager.getCacheNames().stream().toList();
    }
}
