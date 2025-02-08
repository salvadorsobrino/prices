package com.prueba.prices.infraestructure.adapters.output.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(length = 50)
    private String name;
}
