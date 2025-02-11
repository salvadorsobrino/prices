package com.prueba.prices.infraestructure.adapters.output.persistance.mapper;

import com.prueba.prices.domain.model.Brand;
import com.prueba.prices.domain.model.Price;
import com.prueba.prices.domain.model.Product;
import com.prueba.prices.infraestructure.adapters.output.persistance.entity.PriceEntity;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class PricePersistenceMapperImp implements PricePersistenceMapper {

    public Price toPrice(@NonNull final PriceEntity entity) {

        return Price.builder()
                .priceList(entity.getPriceList())
                .brand(Brand.builder()
                        .brandId(entity.getBrandEntity().getBrandId())
                        .name(entity.getBrandEntity().getName())
                        .build())
                .product(Product.builder()
                        .productId(entity.getProductEntity().getProductId())
                        .build())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .value(entity.getValue())
                .build();
    }

}
