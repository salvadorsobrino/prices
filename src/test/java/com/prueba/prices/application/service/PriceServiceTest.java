package com.prueba.prices.application.service;


import com.prueba.prices.application.ports.output.PricePersistencePort;
import com.prueba.prices.domain.Mocks;
import com.prueba.prices.domain.model.Price;
import com.prueba.prices.infraestructure.adapters.output.persistance.exception.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @Mock
    private PricePersistencePort persistencePort;

    @InjectMocks
    private PriceService priceService;

    @Test
    public void testFindByPrice() {
        //Given
        var expectedPrice = Mocks.getPrice();

        var applicationDate = LocalDateTime.of(2025, 2, 11, 10, 0, 0, 0);
        var productId = 35455L;
        var brandId = 1L;

        //When
        when(persistencePort.findByPriorityPrice(any(LocalDateTime.class), any(Long.class), any(Long.class))).thenReturn(expectedPrice);
        Price result = priceService.searchPriorityPrice(applicationDate, productId, brandId);

        //Then
        verify(persistencePort, times(1)).findByPriorityPrice(applicationDate, productId, brandId);
        assertEquals(expectedPrice, result);
        assertEquals(expectedPrice.getBrand().getBrandId(), brandId);
        assertEquals(expectedPrice.getProduct().getProductId(), productId);
    }

    @Test
    public void testFindByPriceException() {
        //Given
        var applicationDate = LocalDateTime.of(2025, 2, 11, 10, 0, 0, 0);
        var productId = 35457L;
        var brandId = 1L;

        //When
        when(persistencePort.findByPriorityPrice(any(LocalDateTime.class), any(Long.class), any(Long.class))).thenThrow(PriceNotFoundException.class);

        //Then
        assertThrows(PriceNotFoundException.class, () -> {
            priceService.searchPriorityPrice(applicationDate, productId, brandId);
        });
    }
}
