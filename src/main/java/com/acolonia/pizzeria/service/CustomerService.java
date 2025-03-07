package com.acolonia.pizzeria.service;

import com.acolonia.pizzeria.persistence.entity.CustomerEntity;
import com.acolonia.pizzeria.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity findByPhone (String phone) {
        return this.customerRepository.findByPhone(phone);
    }
}
