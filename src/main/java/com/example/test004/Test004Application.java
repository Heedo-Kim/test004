package com.example.test004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@EntityScan
public class Test004Application {

    public static void main(String[] args) {
        SpringApplication.run(Test004Application.class, args);
    }

}
