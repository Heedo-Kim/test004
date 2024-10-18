package com.example.test004.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
