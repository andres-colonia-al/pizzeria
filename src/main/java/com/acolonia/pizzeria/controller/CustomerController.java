package com.acolonia.pizzeria.controller;

import com.acolonia.pizzeria.persistence.entity.CustomerEntity;
import com.acolonia.pizzeria.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> getByPhone (@PathVariable String phone) {
        return ResponseEntity.ok(this.customerService.findByPhone(phone));
    }
}
