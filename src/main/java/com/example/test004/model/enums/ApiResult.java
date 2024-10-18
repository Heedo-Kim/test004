package com.example.test004.model.enums;

import lombok.Getter;
import lombok.Setter;

public enum ApiResult {
    NONE(0, "NONE"),
    /* Success Area */
    SUCCESS(200, "success");

    @Getter
    private int resultCode;

    @Getter
    @Setter
    private String message;

    @Getter
    private String defaultMessage;

    ApiResult(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
        this.defaultMessage = message;
    }
}
