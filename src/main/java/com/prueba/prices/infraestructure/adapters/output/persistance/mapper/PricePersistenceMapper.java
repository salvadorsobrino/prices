package com.prueba.prices.infraestructure.adapters.output.persistance.mapper;

import com.prueba.prices.domain.model.Price;
import com.prueba.prices.infraestructure.adapters.output.persistance.entity.PriceEntity;
import lombok.NonNull;

public interface PricePersistenceMapper {
    Price toPrice(@NonNull final PriceEntity entity);
}
