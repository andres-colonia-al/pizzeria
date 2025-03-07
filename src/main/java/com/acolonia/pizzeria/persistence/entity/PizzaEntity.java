package com.acolonia.pizzeria.persistence.entity;

import com.acolonia.pizzeria.persistence.Audit.AuditPizzaListener;
import com.acolonia.pizzeria.persistence.Audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Table(name = "pizza")
@EntityListeners({AuditingEntityListener.class, AuditPizzaListener.class}) // listener de auditoria
@Setter
@Getter
@NoArgsConstructor
public class PizzaEntity extends AuditableEntity implements Serializable {
    //configuración de atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double price;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;



}
