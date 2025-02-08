package com.prueba.prices.infraestructure.adapters.input.rest.controller;

import com.prueba.prices.infraestructure.adapters.output.persistance.exception.PriceNotFoundException;
import com.prueba.prices.infraestructure.adapters.input.rest.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

import static com.prueba.prices.infraestructure.adapters.input.rest.utils.ErrorCatalog.INVALID_REQUEST;
import static com.prueba.prices.infraestructure.adapters.input.rest.utils.ErrorCatalog.PRICE_NOT_FOUND;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PriceNotFoundException.class)
    public ErrorResponse handlePriceNotFoundException() {
        return ErrorResponse.builder()
                .code(PRICE_NOT_FOUND.getCode())
                .message(PRICE_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception) {

        return ErrorResponse.builder()
                .code(INVALID_REQUEST.getCode())
                .message(INVALID_REQUEST.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
