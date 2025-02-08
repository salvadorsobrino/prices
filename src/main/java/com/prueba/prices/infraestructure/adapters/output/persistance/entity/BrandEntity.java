package com.prueba.prices.infraestructure.adapters.output.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity()
@Table(name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandEntity {
    @Id
    @Column(name = "BRAND_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    @Column(length = 50)
    private String name;

}
