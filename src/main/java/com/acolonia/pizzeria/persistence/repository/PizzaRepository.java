package com.acolonia.pizzeria.persistence.repository;

import com.acolonia.pizzeria.persistence.entity.PizzaEntity;
import com.acolonia.pizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    /* Opcion 1: utilizando anotaciones para la actualizacion de datos en la BD
    @Query(value = "UPDATE pizza " +
            "SET price = :newPrice " +
            "WHERE id_pizza = :idPizza", nativeQuery = true)
    void updatePrice (@Param("idPizza") int idPizza, @Param("newPrice") double newPrice);
     */

    //Opcion 2: Uso de SPEL Spring Expression Language
    @Query(value = "UPDATE pizza " +
            "SET price = :#{#newPizzaPrice.newPrice} " +
            "WHERE id_pizza = :#{#newPizzaPrice.pizzaId}", nativeQuery = true)
    @Modifying
    void updatePrice (@Param("newPizzaPrice")UpdatePizzaPriceDto newPizzaPrice);

}
