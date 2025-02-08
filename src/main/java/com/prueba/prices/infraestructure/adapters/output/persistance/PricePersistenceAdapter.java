package com.prueba.prices.infraestructure.adapters.output.persistance;

import com.prueba.prices.application.ports.output.PricePersistencePort;
import com.prueba.prices.domain.model.Price;
import com.prueba.prices.infraestructure.adapters.output.persistance.exception.PriceNotFoundException;
import com.prueba.prices.infraestructure.adapters.output.persistance.mapper.PricePersistenceMapperImp;
import com.prueba.prices.infraestructure.adapters.output.persistance.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PricePersistenceAdapter implements PricePersistencePort {

    private final PriceRepository repository;
    private final PricePersistenceMapperImp mapper;

    @Override
    public Price findByPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return mapper.toPrice(repository.selectPriceRate(applicationDate,productId,brandId)
                .orElseThrow(PriceNotFoundException::new));

    }
}
