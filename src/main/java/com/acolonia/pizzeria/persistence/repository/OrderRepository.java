package com.acolonia.pizzeria.persistence.repository;

import com.acolonia.pizzeria.persistence.Projection.OrderSummary;
import com.acolonia.pizzeria.persistence.entity.Enum.MethodEnum;
import com.acolonia.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {

    // Query Methods After (Antes de la fecha atual)
    List<OrderEntity> findAllByDateAfter (LocalDateTime date);

    // Query Methods In (Buscar entre dos opciones de methods)
    List<OrderEntity> findAllByMethodIn (List<MethodEnum> methods);

    // Consulta utilizando SQL nativo
    @Query(value = "SELECT * FROM pizza_order WHERE id_customer =:id" , nativeQuery = true)
    List<OrderEntity> findCustomerOrders(@Param("id") String idCustomer);

    @Query(value =
            "SELECT po.id_order AS idOrder, c.name AS customerName,po.date AS orderDate, " +
            "po.total AS orderTotal, GROUP_CONCAT(p.name) AS pizzaNames " +
            "FROM pizza_order po " +
            "JOIN customer c ON po.id_customer = c.id_customer " +
            "JOIN order_item oi ON po.id_order = oi.id_order " +
            "JOIN pizza p ON oi.id_pizza = p.id_pizza " +
            "WHERE po.id_order = :orderId " +
            "GROUP BY po.id_order, c.name, po.date, po.total;", nativeQuery = true)
    OrderSummary findSummary (@Param("orderId") int orderId);
}
