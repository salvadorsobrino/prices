package com.prueba.prices.application.ports.output;

import com.prueba.prices.domain.model.Price;

import java.time.LocalDateTime;


public interface PricePersistencePort {

    Price findByPriorityPrice(LocalDateTime applicationDate, Long productId, Long brandId);

}
