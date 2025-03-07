package com.acolonia.pizzeria.service;

import com.acolonia.pizzeria.persistence.entity.PizzaEntity;
import com.acolonia.pizzeria.persistence.repository.PizzaPagSortRepository;
import com.acolonia.pizzeria.persistence.repository.PizzaRepository;
import com.acolonia.pizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PizzaService {

    @Autowired
    private PizzaRepository repository;

    @Autowired
    private PizzaPagSortRepository pizzaPagSortRepository;

    //Paginación del listado de pizzas
    public Page<PizzaEntity> getAllPag (int page, int elements){
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.pizzaPagSortRepository.findAll(pageRequest);
    }

    //Paginación del listado de pizzas ordenadas
    public Page<PizzaEntity> getAvailablePag (int page, int elements, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(page, elements, sort);
        return this.pizzaPagSortRepository.findByAvailableTrue(pageable);
    }

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

    @Transactional
    public void updatePrice (UpdatePizzaPriceDto updatePizzaPriceDto) {
        this.repository.updatePrice(updatePizzaPriceDto);
    }

}
