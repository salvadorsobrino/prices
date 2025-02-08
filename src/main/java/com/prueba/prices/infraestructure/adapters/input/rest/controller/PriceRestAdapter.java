package com.prueba.prices.infraestructure.adapters.input.rest.controller;

import com.prueba.prices.application.ports.input.PriceServicePort;
import com.prueba.prices.infraestructure.adapters.input.rest.mapper.PriceRestMapperImp;
import com.prueba.prices.infraestructure.adapters.input.rest.model.response.ErrorResponse;
import com.prueba.prices.infraestructure.adapters.input.rest.model.response.PriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
@Tag(name = "Prices", description = "Operaciones relacionadas con la tarifa/precio")
public class PriceRestAdapter {

    private final PriceServicePort servicePort;

    private final PriceRestMapperImp restMapper;

    @Operation(
            summary = "Obtener la tarifa de un producto dada una marca id,producto id y una fecha.",
            description = "Este endpoint devuelve la tarifa de un producto dada una id marca id ,producto id y una fecha." +
                    "Si el producto no se encuentra, devuelve un error 404 o bad request 400.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Precio encontrado.",
                            content = @Content(
                                    schema = @Schema(implementation = PriceResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Producto no encontrado.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos incorrectos.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )
    @GetMapping("/v1/api/{applicationDate}/{productId}/{brandId}")
    public ResponseEntity<PriceResponse> findByPrice(
            @Parameter(description = "Fecha y hora de la tarifa", example = "2025-02-08T23:59:99", required = true)
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") @NotNull LocalDateTime applicationDate,
            @Parameter(description = "Id del producto", example = "35455", required = true)
            @PathVariable @NotNull Long productId,
            @Parameter(description = "Id de la marca", example = "1", required = true)
            @PathVariable @NotNull Long brandId) {

        return ResponseEntity.ok(restMapper.toPriceResponse(servicePort.findByPrice(applicationDate,productId,brandId)));

    }

}
