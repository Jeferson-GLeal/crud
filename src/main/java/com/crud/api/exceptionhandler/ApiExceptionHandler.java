package com.crud.api.exceptionhandler;

import com.crud.api.domain.exception.CadastroException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CadastroException.class)
    public ResponseEntity<String> capturar (CadastroException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
