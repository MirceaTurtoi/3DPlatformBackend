package com.platfrom3d.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        // Create payload with exception details
        ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        // Return response entity
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
