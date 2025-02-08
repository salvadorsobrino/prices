package com.prueba.prices.application.ports.input;

import com.prueba.prices.domain.model.Price;

import java.time.LocalDateTime;


public interface PriceServicePort {

    Price findByPrice(LocalDateTime applicationDate, Long productId, Long brandId);

}
