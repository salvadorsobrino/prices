package com.prueba.prices.infraestructure.adapters.input.rest.controller;

import com.prueba.prices.infraestructure.adapters.input.rest.model.response.PriceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PriceRestAdapterTest {

    @Autowired
    private WebTestClient client;
    @Test
    void testRequestAt10AMDay14(){
        //Given
        //When
        client.get().uri("/prices/v1/api/2020-06-14T10:00:00/35455/1").exchange()
                //Then
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceResponse.class)
                .consumeWith(response -> {
                    PriceResponse price = response.getResponseBody();
                    assertNotNull(price);
                    assertEquals(1L, price.getPriceList());
                    assertEquals(35455L, price.getProductId());
                    assertEquals(1L, price.getBrandId());
                    assertEquals(LocalDateTime.of(2020,6,14,0,0,0), price.getStartDate());
                    assertEquals(LocalDateTime.of(2020,12,31,23,59,59), price.getEndDate());
                    assertEquals(BigDecimal.valueOf(35.5), price.getValue());
                });
    }
    @Test
    void testRequestAt4PMDay14(){
        //Given
        //When
        client.get().uri("/prices/v1/api/2020-06-14T16:00:00/35455/1").exchange()
                //Then
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceResponse.class)
                .consumeWith(response -> {
                    PriceResponse price = response.getResponseBody();
                    assertNotNull(price);
                    assertEquals(35455L, price.getProductId());
                    assertEquals(1L, price.getBrandId());
                    assertEquals(LocalDateTime.of(2020,6,14,15,0,0), price.getStartDate());
                    assertEquals(LocalDateTime.of(2020,6,14,18,30,0), price.getEndDate());
                    assertEquals(BigDecimal.valueOf(25.45), price.getValue());
                });
    }
    @Test
    void testRequestAt9PMDay14(){
        //Given
        //When
        client.get().uri("/prices/v1/api/2020-06-14T21:00:00/35455/1").exchange()
                //Then
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceResponse.class)
                .consumeWith(response -> {
                    PriceResponse price = response.getResponseBody();
                    assertNotNull(price);
                    assertEquals(35455L, price.getProductId());
                    assertEquals(1L, price.getBrandId());
                    assertEquals(LocalDateTime.of(2020,6,14,0,0,0), price.getStartDate());
                    assertEquals(LocalDateTime.of(2020,12,31,23,59,59), price.getEndDate());
                    assertEquals(BigDecimal.valueOf(35.5), price.getValue());
                });
    }
    @Test
    void testRequestAt10AMDay15(){
        //Given
        //When
        client.get().uri("/prices/v1/api/2020-06-15T10:00:00/35455/1").exchange()
                //Then
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceResponse.class)
                .consumeWith(response -> {
                    PriceResponse price = response.getResponseBody();
                    assertNotNull(price);
                    assertEquals(35455L, price.getProductId());
                    assertEquals(1L, price.getBrandId());
                    assertEquals(LocalDateTime.of(2020,6,15,0,0,0), price.getStartDate());
                    assertEquals(LocalDateTime.of(2020,6,15,11,0,0), price.getEndDate());
                    assertEquals(BigDecimal.valueOf(30.5), price.getValue());
                });
    }
    @Test
    void testRequestAt9PMDay16(){
        //Given
        //When
        client.get().uri("/prices/v1/api/2020-06-16T21:00:00/35455/1").exchange()
                //Then
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceResponse.class)
                .consumeWith(response -> {
                    PriceResponse price = response.getResponseBody();
                    assertNotNull(price);
                    assertEquals(35455L, price.getProductId());
                    assertEquals(1L, price.getBrandId());
                    assertEquals(LocalDateTime.of(2020,6,15,16,0,0), price.getStartDate());
                    assertEquals(LocalDateTime.of(2020,12,31,23,59,59), price.getEndDate());
                    assertEquals(BigDecimal.valueOf(38.95), price.getValue());
                });
    }
}

