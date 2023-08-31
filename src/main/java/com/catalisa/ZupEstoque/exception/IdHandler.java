package com.catalisa.ZupEstoque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class IdHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Id não foi passado")
    @ExceptionHandler
    public ResponseEntity<String> idNotFound(IdError ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
