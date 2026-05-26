package com.pedrohlopes.musicPub.handler;

import com.pedrohlopes.musicPub.exception.BusinessException;
import com.pedrohlopes.musicPub.exception.ErrorResponse;
import com.pedrohlopes.musicPub.exception.FieldErrorResponse;
import com.pedrohlopes.musicPub.exception.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        ErrorResponse response = new ErrorResponse(ex.getMessage(), 409);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
