package com.acolonia.pizzeria.persistence.Projection;

import java.time.LocalDateTime;

public interface OrderSummary {

    Integer getIdOrder();

    String getCustomerName();

    LocalDateTime getOrderDate();

    Double getOrderTotal();

    String getPizzaNames();
}
