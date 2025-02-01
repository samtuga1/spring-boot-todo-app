package com.demo.todo.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiError extends RuntimeException {

    HttpStatus code;
    String message;

    public ApiError(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    ResponseEntity<Map<String, Object>> makeError() {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", code.value());
        errorResponse.put("message", message);
        errorResponse.put("success", false);

        return ResponseEntity.status(code).body(errorResponse);
    }

}