package com.prueba.prices.infraestructure.adapters.output.persistance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity()
@Table(name="prices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceEntity {
    @Id
    @Column(name = "PRICE_LIST")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceList;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", nullable = false)
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID", nullable = false)
    private BrandEntity brandEntity;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    @Column(precision = 1, nullable = false)
    private Integer priority;

    @Column(name="PRICE", scale = 2, nullable = false)
    private BigDecimal value;

    @Column(length = 3, nullable = false)
    private String curr;

}
