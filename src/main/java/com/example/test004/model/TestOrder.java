package com.example.test004.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TestOrder {
    @JsonProperty(value = "order_sampleeee")
    private String orderSample;
    @JsonProperty(value = "note_sample")
    private String noteSample;
}
