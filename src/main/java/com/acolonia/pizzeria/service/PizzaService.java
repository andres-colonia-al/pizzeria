package com.acolonia.pizzeria.service;

import com.acolonia.pizzeria.persistence.entity.PizzaEntity;
import com.acolonia.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PizzaService {

    @Autowired
    private PizzaRepository repository;

    public List<PizzaEntity> getAll() {
        return this.repository.findAll();
    }

    public List<PizzaEntity> getAvailable () {
        System.out.println(this.repository.countByVeganTrue());
        return this.repository.findAllByAvailableTrueOrderByPrice();
    }

    public PizzaEntity getAvailableByName (String name) {
        return this.repository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    public List<PizzaEntity> getWith (String description) {
        return this.repository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getTop (double price) {
        return this.repository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    public List<PizzaEntity> getWithNot (String description) {
        return this.repository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
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
