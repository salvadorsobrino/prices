package com.prueba.prices.infraestructure.adapters.input.rest.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Representa un mensaje de error en la API")
public class ErrorResponse {

    @Schema(description = "Código de error", example = "ERR_PRICE_001", required = true)
    private String code;

    @Schema(description = "Mensaje de error", example = "PRICE not found.", required = true)
    private String message;

    @Schema(description = "Fecha y hora del error", example = "2025-02-08T14:51:37.1068435", required = true)
    private LocalDateTime timestamp;

}
