package com.example.test004.controller;

import com.example.test004.service.RandomEvictService;
import com.example.test004.service.RandomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
@RequiredArgsConstructor
public class CacheController {
    private final RandomService randomService;
    private final RandomEvictService randomEvictService;
    @GetMapping("/")
    public ResponseEntity<String> getSimpleRandom(@RequestParam("id") String id) {
        return ResponseEntity.ok(randomService.cacheTest(id));
    }

    @GetMapping("/test2/")
    public ResponseEntity<String> getSimpleRandom2(@RequestParam("id") String id) {
        return ResponseEntity.ok(randomService.cacheNameTest(id));
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllCacheNames() {
        return ResponseEntity.ok(randomService.fetchAllCacheNames());
    }

    @GetMapping("/clear/randomService")
    public void evictTest1() {
        randomEvictService.clearRandomService();
    }
}
