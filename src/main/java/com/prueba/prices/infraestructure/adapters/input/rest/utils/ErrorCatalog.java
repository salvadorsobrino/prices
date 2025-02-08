package com.prueba.prices.infraestructure.adapters.input.rest.utils;


import lombok.Getter;

@Getter
public enum ErrorCatalog {

    PRICE_NOT_FOUND("ERR_PRICE_001", "PRICE not found."),
    INVALID_REQUEST("ERR_PRICE_002", "Invalid PRICE REQUEST parameters.");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

}