package com.prueba.prices.infraestructure.adapters.input.rest.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Representa un precio/tarifa.")
public class PriceResponse {

    @Schema(description = "ID único del precio/tarifa", example = "1", required = true)
    private Long priceList;
    @Schema(description = "ID único del producto", example = "35455", required = true)
    private Long productId;
    @Schema(description = "ID único de la marca", example = "1", required = true)
    private Long brandId;
    @JsonFormat(pattern = "yyyy-MM-dd HH.mm.ss")
    @Schema(description = "Fecha inicio de la tarifa", example = "2025-02-08T00:00:00", required = true)
    private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH.mm.ss")
    @Schema(description = "Fecha fin de la tarifa", example = "2025-02-08T23:59:99", required = true)
    private LocalDateTime endDate;
    @Schema(description = "Precio del producto", example = "123.23", required = true)
    private BigDecimal price;

}
