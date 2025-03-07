package com.acolonia.pizzeria.controller;

import com.acolonia.pizzeria.persistence.entity.PizzaEntity;
import com.acolonia.pizzeria.service.PizzaService;
import com.acolonia.pizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {


    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/pag")
    public ResponseEntity<Page<PizzaEntity>> getAllPage(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "8") int elements) {
        return ResponseEntity.ok(this.pizzaService.getAllPag(page, elements));
    }

    @GetMapping("/pag-sort")
    public ResponseEntity<Page<PizzaEntity>> getAllPage(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "8") int elements,
                                                        @RequestParam(defaultValue = "price") String sortBy,
                                                        @RequestParam(defaultValue = "ASC") String sortDirection) {
        return ResponseEntity.ok(this.pizzaService.getAvailablePag(page, elements, sortBy, sortDirection));
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int idPizza) {
        return ResponseEntity.ok(this.pizzaService.get(idPizza));
    }

    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getAvailable() {
        return ResponseEntity.ok(this.pizzaService.getAvailable());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getAvailableByName(@PathVariable String name) {
        return ResponseEntity.ok(this.pizzaService.getAvailableByName(name));
    }

    @GetMapping("/with/{description}")
    public ResponseEntity<List<PizzaEntity>> getWith(@PathVariable String description) {
        return ResponseEntity.ok(this.pizzaService.getWith(description));
    }
    @GetMapping("/cheapper/{price}")
    public ResponseEntity<List<PizzaEntity>> getCheapperPizza (@PathVariable double price) {
        return ResponseEntity.ok(this.pizzaService.getTop(price));
    }

    @GetMapping("/without/{description}")
    public ResponseEntity<List<PizzaEntity>> getWithNot(@PathVariable String description) {
        return ResponseEntity.ok(this.pizzaService.getWithNot(description));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() == null || !this.pizzaService.exists(pizza.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() != null && this.pizzaService.exists(pizza.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> delete(@PathVariable int idPizza) {
        if (this.pizzaService.exists(idPizza)) {
            this.pizzaService.delete(idPizza);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/price")
    public ResponseEntity<Void> updatePrice (@RequestBody UpdatePizzaPriceDto dto) {
        if (this.pizzaService.exists(dto.getPizzaId())) {
            this.pizzaService.updatePrice(dto);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

}