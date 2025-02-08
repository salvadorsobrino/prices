package com.prueba.prices.controller;

import com.prueba.prices.infraestructure.adapters.input.rest.model.response.ErrorResponse;
import com.prueba.prices.infraestructure.adapters.input.rest.utils.ErrorCatalog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class GlobalControllerAdviceTest {

    @Autowired
    private WebTestClient client;

    @Test
    void TestPriceNotFoundException(){
        //Given
        //When
        client.get().uri("/prices/v1/api/2020-06-14T10:00:00/35455/12").exchange()
                //Then
                .expectStatus().is4xxClientError()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ErrorResponse.class)
                .consumeWith(response -> {
                    ErrorResponse errorResponse = response.getResponseBody();
                    assertNotNull(errorResponse);
                    assertEquals(ErrorCatalog.PRICE_NOT_FOUND.getCode(), errorResponse.getCode());
                    assertEquals(ErrorCatalog.PRICE_NOT_FOUND.getMessage(), errorResponse.getMessage());
                });
    }
    @Test
    void TestMethodArgumentTypeMismatchException() {
        //Given
        //When
        client.get().uri("/prices/v1/api/2020-06-1410:00:00/35455/1").exchange()
                //Then
                .expectStatus().is4xxClientError()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ErrorResponse.class)
                .consumeWith(response -> {
                    ErrorResponse errorResponse = response.getResponseBody();
                    assertNotNull(errorResponse);
                    assertEquals(ErrorCatalog.INVALID_REQUEST.getCode(), errorResponse.getCode());
                    assertEquals(ErrorCatalog.INVALID_REQUEST.getMessage(), errorResponse.getMessage());
                });
    }
}
