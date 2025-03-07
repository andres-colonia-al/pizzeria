package com.acolonia.pizzeria.persistence.repository;

import com.acolonia.pizzeria.persistence.entity.PizzaEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer> {

    //metodo para buscar pizzas disponibles y mostrar una paginación
    Page<PizzaEntity> findByAvailableTrue(Pageable pageable);

}
