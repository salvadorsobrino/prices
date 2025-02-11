package com.prueba.prices.domain;

import com.prueba.prices.domain.model.Brand;
import com.prueba.prices.domain.model.Price;
import com.prueba.prices.domain.model.Product;
import com.prueba.prices.infraestructure.adapters.input.rest.model.response.PriceResponse;
import com.prueba.prices.infraestructure.adapters.output.persistance.entity.BrandEntity;
import com.prueba.prices.infraestructure.adapters.output.persistance.entity.PriceEntity;
import com.prueba.prices.infraestructure.adapters.output.persistance.entity.ProductEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Mocks {

    public static Price getPrice(){
        return Price.builder()
                .priceList(1L)
                .product(getProduct())
                .brand(getBrand())
                .startDate(LocalDateTime.of(2025, 2, 11,
                        10, 0, 0, 0))
                .endDate(LocalDateTime.of(2025, 2, 11,
                        10, 0, 0, 0))
                .priority(0)
                .value(BigDecimal.valueOf(30.5))
                .curr("EUR")
                .build();
    }

    public static Brand getBrand(){
        return Brand.builder().
                brandId(1L)
                .name("ZARA")
                .build();
    }
    public static Product getProduct(){
        return Product.builder()
                .productId(35455L)
                .build();
    }
    public static PriceResponse getPriceResponse() {
        var price = getPrice();
        return PriceResponse.builder()
                .priceList(price.getPriceList())
                .productId(price.getProduct().getProductId())
                .brandId(price.getBrand().getBrandId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .value(price.getValue())
                .build();
    }
    public static PriceEntity getPriceEntity(){
        return PriceEntity.builder()
                .priceList(1L)
                .productEntity(getProductEntity())
                .brandEntity(getBrandEntity())
                .startDate(LocalDateTime.of(2025, 2, 11,
                        10, 0, 0, 0))
                .endDate(LocalDateTime.of(2025, 2, 11,
                        10, 0, 0, 0))
                .priority(0)
                .value(BigDecimal.valueOf(30.5))
                .curr("EUR")
                .build();
    }

    public static BrandEntity getBrandEntity(){
        return BrandEntity.builder().
                brandId(1L)
                .name("ZARA")
                .build();
    }
    public static ProductEntity getProductEntity(){
        return ProductEntity.builder()
                .productId(35455L)
                .build();
    }
}
