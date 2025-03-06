package com.acolonia.pizzeria.persistence.repository;

import com.acolonia.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {

    // Query Methods True - OrderBy -By
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice ();

    // Query Methods True - By - And - IgnoreCase
    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);

    // Query Methods True - By - And - ContainingIgnoreCase
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

    // Query Methods True - By - And - Not - ContainingIgnoreCase
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

    Integer countByVeganTrue();

    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc (double price);
}
