package com.example.test004.model;

import com.example.test004.model.enums.ApiResult;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class TestApiResponse {
    ApiResult result;
    Object data;

    public TestApiResponse(ApiResult result) {
        this.result = result;
    }
    public TestApiResponse(ApiResult result, Object data) {
        this.result = result;
        this.data = data;
    }

    public String getMessage() {
        return result.getDefaultMessage();
    }

    public String getResult() {
        return result.getMessage();
    }

    public long getResultCode() {
        return result.getResultCode();
    }
}
