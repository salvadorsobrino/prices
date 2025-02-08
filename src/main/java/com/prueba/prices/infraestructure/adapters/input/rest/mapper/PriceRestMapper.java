package com.prueba.prices.infraestructure.adapters.input.rest.mapper;

import com.prueba.prices.domain.model.Price;
import com.prueba.prices.infraestructure.adapters.input.rest.model.response.PriceResponse;

public interface PriceRestMapper {
    PriceResponse toPriceResponse(Price price);
}
