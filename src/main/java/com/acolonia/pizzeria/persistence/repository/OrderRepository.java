package com.acolonia.pizzeria.persistence.repository;

import com.acolonia.pizzeria.persistence.entity.Enum.MethodEnum;
import com.acolonia.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {

    // Query Methods After (Antes de la fecha atual)
    List<OrderEntity> findAllByDateAfter (LocalDateTime date);

    // Query Methods In (Buscar entre dos opciones de methods)
    List<OrderEntity> findAllByMethodIn (List<MethodEnum> methods);
}
