package com.example.test004.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class HelloResponseDtoTest {

    @Test
    public void lombok_dto_test() {
        // given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = HelloResponseDto.builder()
                .name(name)
                .amount(amount)
                .build();

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}