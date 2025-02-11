package com.prueba.prices.infraestructure.adapters.input.rest.mapper;

import com.prueba.prices.domain.model.Price;

import com.prueba.prices.infraestructure.adapters.input.rest.model.response.PriceResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceRestMapperImp implements PriceRestMapper{

    public PriceResponse toPriceResponse(Price price) {

        return PriceResponse.builder()
                .priceList(price.getPriceList())
                .brandId(price.getBrand().getBrandId())
                .productId(price.getProduct().getProductId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .value(price.getValue())
                .build();

    }

}


