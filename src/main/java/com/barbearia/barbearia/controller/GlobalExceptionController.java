package com.barbearia.barbearia.controller;

import com.barbearia.barbearia.dto.ResponseDTO;
import com.barbearia.barbearia.exception.BadRequestException;
import com.barbearia.barbearia.exception.ConflitException;
import com.barbearia.barbearia.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseDTO handleNotFoundException(NotFoundException ex) {
        String messageError = ex.getMessage();
        return new ResponseDTO(messageError);
    }

    @ExceptionHandler(ConflitException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseDTO handleConflitException(ConflitException ex) {
        String messageError = ex.getMessage();
        return new ResponseDTO(messageError);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO handleBadRequestException(BadRequestException ex) {
        String messageError = ex.getMessage();
        return new ResponseDTO(messageError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> erros = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            erros.add(errorMessage);
        });

        return new ResponseDTO(erros);
    }
}