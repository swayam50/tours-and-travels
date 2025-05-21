package com.telusko.tat.exmap;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.telusko.tat.model.exchange.GenericResponse;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> data = new HashMap<>();
        for (FieldError error : ex.getFieldErrors())
            data.putIfAbsent(error.getField(), error.getDefaultMessage());
        return new ResponseEntity<>(GenericResponse.error("Input fields are invalid", data), UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {HttpMediaTypeException.class, HttpRequestMethodNotSupportedException.class})
    public <E extends ErrorResponse> ResponseEntity<GenericResponse> handleHttpException(E ex) {
        ProblemDetail problemDetail = ex.getBody();
        return new ResponseEntity<>(GenericResponse.error(problemDetail.getTitle(), problemDetail.getDetail()), ex.getStatusCode());
    }

}
