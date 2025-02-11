package com.prueba.prices.infraestructure.adapters.input.rest.mapper;

import com.prueba.prices.domain.Mocks;
import com.prueba.prices.infraestructure.adapters.input.rest.model.response.PriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PriceRestMapperImpTest {

    @InjectMocks
    PriceRestMapperImp priceRestMapperImp;

    @Test
    public void toPriceResponseTest() {
        //Given
        var price = Mocks.getPrice();
        //When
        PriceResponse priceResponse = priceRestMapperImp.toPriceResponse(price);
        //Then
        assertNotNull(priceResponse);
        assertEquals(price.getPriceList(), priceResponse.getPriceList());
        assertEquals(price.getBrand().getBrandId(), priceResponse.getBrandId());
        assertEquals(price.getProduct().getProductId(), priceResponse.getProductId());
        assertEquals(price.getStartDate(), priceResponse.getStartDate());
        assertEquals(price.getEndDate(), priceResponse.getEndDate());
        assertEquals(price.getValue(), priceResponse.getValue());
    }
}
