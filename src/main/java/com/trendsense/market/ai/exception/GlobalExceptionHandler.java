package com.trendsense.market.ai.exception;

import com.trendsense.market.ai.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public org.springframework.http.ResponseEntity<ApiResponse<Map<String, String>>> handleResourceNotFound(
            ResourceNotFoundException ex
    ) {
        return org.springframework.http.ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("Resource not found", Map.of("error", ex.getMessage())));
    }

    @ExceptionHandler(Exception.class)
    public org.springframework.http.ResponseEntity<ApiResponse<Map<String, String>>> handleGenericException(
            Exception ex
    ) {
        return org.springframework.http.ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Internal server error", Map.of("error", ex.getMessage())));
    }
}