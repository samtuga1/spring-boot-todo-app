package com.demo.todo.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity<Map<String, Object>> success(String message) {
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("success", true);
        data.put("status", HttpStatus.OK.value());
        data.put("message", message);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    public static ResponseEntity<Map<String, Object>> successWithData(String message, Object data) {

        Map<String, Object> responseData = new HashMap<String, Object>();

        responseData.put("success", true);
        responseData.put("status", HttpStatus.CREATED.value());
        responseData.put("message", message);
        responseData.put("data", data);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    public static ResponseEntity<Map<String, Object>> send(HttpStatus status, String message, Object data) {

        Map<String, Object> responseData = new HashMap<String, Object>();

        responseData.put("success", true);
        responseData.put("status", status);
        if (message != null)
            responseData.put("message", message);
        if (data != null)
            responseData.put("data", data);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

}
