package com.acolonia.pizzeria.persistence.entity;

import com.acolonia.pizzeria.persistence.entity.Enum.MethodEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class OrderEntity {
    //configuración de atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;

    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double total;

    @Enumerated(EnumType.STRING) //relaciona el atribruto con un enumerador
    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private MethodEnum method;

    @Column(name = "additional_notes", length = 200)
    private String additionalNotes;

    //Configuración de relaciones entre entidades
    @OneToOne
    // name -> Especifica el nombre de la columna en la tabla actual que actúa como clave foránea.
    // referencedColumnName -> Indica la columna en la tabla de la entidad referenciada que está siendo apuntada como clave primaria.
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order")
    // mappedBy -> indica que la entidad esta mapeada por el atributo order en la entidad OrderItemEntity
    private List<OrderItemEntity> items;
}
