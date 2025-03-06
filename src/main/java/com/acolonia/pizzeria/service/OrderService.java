package com.acolonia.pizzeria.service;

import com.acolonia.pizzeria.persistence.entity.Enum.MethodEnum;
import com.acolonia.pizzeria.persistence.entity.OrderEntity;
import com.acolonia.pizzeria.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll() {
        return this.orderRepository.findAll();
    }

    public List<OrderEntity> getTodayOrders() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.orderRepository.findAllByDateAfter(today);
    }

    public List<OrderEntity> getOutsideOrders() {
        List<MethodEnum> methods = Arrays.asList(MethodEnum.D, MethodEnum.C);
        return this.orderRepository.findAllByMethodIn(methods);
    }

}
