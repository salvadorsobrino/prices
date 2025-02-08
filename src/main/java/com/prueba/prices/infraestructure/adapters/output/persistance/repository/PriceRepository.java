package com.prueba.prices.infraestructure.adapters.output.persistance.repository;

import com.prueba.prices.infraestructure.adapters.output.persistance.entity.PriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {

@Query( "SELECT p FROM PriceEntity p " +
        "INNER JOIN BrandEntity b ON p.brandEntity.brandId = b.brandId " +
        "WHERE p.productEntity.productId = :productId " +
        "AND p.brandEntity.brandId = :brandId " +
        "AND :applicationDate BETWEEN p.startDate AND p.endDate " +
        "ORDER BY p.priority DESC LIMIT 1" )
    Optional<PriceEntity> selectPriceRate(@Param("applicationDate") LocalDateTime applicationDate,
                                         @Param("productId") long productId,
                                         @Param("brandId") long brandId);

}
