package com.caiorian.api_todo.adapter.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeptionHandle {


    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> responseStatusExceptionHandle(ResponseStatusException exception){
        Map<String, Object> response = new HashMap<>();
        response.put("status: ", exception.getStatusCode().toString());
        response.put("message: ", exception.getReason());

        return ResponseEntity.status(exception.getStatusCode()).body(response);
    }

}
