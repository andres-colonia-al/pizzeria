package com.acolonia.pizzeria.service;

import com.acolonia.pizzeria.persistence.entity.PizzaEntity;
import com.acolonia.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PizzaService {

    @Autowired
    private PizzaRepository repository;

    public List<PizzaEntity> getAll() {
        return this.repository.findAll();
    }

    public PizzaEntity get(int idPizza) {
        return this.repository.findById(idPizza).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza) {
        return this.repository.save(pizza);
    }

    public void delete(int idPizza) {
        this.repository.deleteById(idPizza);
    }

    public boolean exists(int idPizza) {
        return this.repository.existsById(idPizza);
    }

}
