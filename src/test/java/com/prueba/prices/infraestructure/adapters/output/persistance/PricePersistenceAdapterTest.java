package com.prueba.prices.infraestructure.adapters.output.persistance;

import com.prueba.prices.domain.Mocks;
import com.prueba.prices.domain.model.Price;
import com.prueba.prices.infraestructure.adapters.output.persistance.entity.PriceEntity;
import com.prueba.prices.infraestructure.adapters.output.persistance.mapper.PricePersistenceMapperImp;
import com.prueba.prices.infraestructure.adapters.output.persistance.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricePersistenceAdapterTest {

    @Mock
    private PriceRepository priceRepository;
    @Mock
    private PricePersistenceMapperImp pricePersistenceMapper;
    @InjectMocks
    private PricePersistenceAdapter pricePersistenceAdapter;

    @Test
    public void testFindByPrice() {
        // Given
        LocalDateTime applicationDate = LocalDateTime.of(2025, 2, 11, 10, 0, 0, 0);
        var productId = 35455L;
        var brandId = 1L;

        // When
        PriceEntity priceEntity = Mocks.getPriceEntity();
        when(priceRepository.selectPriceRate(applicationDate, productId, brandId))
                .thenReturn(Optional.of(priceEntity));


        Price expectedPrice = Mocks.getPrice();
        when(pricePersistenceMapper.toPrice(priceEntity)).thenReturn(expectedPrice);

        Price actualPrice = pricePersistenceAdapter.findByPrice(applicationDate, productId, brandId);

        // Then
        assertNotNull(actualPrice);
        assertEquals(expectedPrice, actualPrice);
    }
}
