package com.prueba.prices.infraestructure.adapters.output.persistance.mapper;

import com.prueba.prices.domain.Mocks;
import com.prueba.prices.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PricePersistenceMapperImpTest {

    @InjectMocks
    PricePersistenceMapperImp pricePersistenceMapperImp;

    @Test
    public void toPriceTest() {
        //Given
        var priceEntity = Mocks.getPriceEntity();
        //When
        Price price = pricePersistenceMapperImp.toPrice(priceEntity);
        //Then
        assertNotNull(price);
        assertEquals(priceEntity.getPriceList(), price.getPriceList());
        assertEquals(priceEntity.getBrandEntity().getBrandId(), price.getBrand().getBrandId());
        assertEquals(priceEntity.getProductEntity().getProductId(), price.getProduct().getProductId());
        assertEquals(priceEntity.getStartDate(), price.getStartDate());
        assertEquals(priceEntity.getEndDate(), price.getEndDate());
        assertEquals(priceEntity.getValue(), price.getValue());
    }
}
