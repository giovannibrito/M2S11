package com.example.demo.handlers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity trataErro404() {
        return ResponseEntity.status(404).body("Id não encontrado.");
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity SqlError(){
        return ResponseEntity.status(412).body("Não é possível excluir essa entidade pois ela é pai de outras entidades existentes.");
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity idPaiInvalido(){
        return ResponseEntity.status(404).body("Não foi possível encontrar o ID especificado da entidade pai");
    }
}
