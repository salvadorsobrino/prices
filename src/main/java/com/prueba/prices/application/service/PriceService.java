package com.prueba.prices.application.service;

import com.prueba.prices.application.ports.input.PriceServicePort;
import com.prueba.prices.application.ports.output.PricePersistencePort;
import com.prueba.prices.domain.model.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService implements PriceServicePort {

    private final PricePersistencePort persistencePort;

    @Override
    public Price searchPriorityPrice(LocalDateTime applicationDate, Long productId, Long brandId) {

        return persistencePort.findByPriorityPrice(applicationDate, productId, brandId);
    }
}
