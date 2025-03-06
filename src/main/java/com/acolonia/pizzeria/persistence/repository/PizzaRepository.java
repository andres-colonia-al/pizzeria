package com.acolonia.pizzeria.persistence.repository;

import com.acolonia.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {
}
