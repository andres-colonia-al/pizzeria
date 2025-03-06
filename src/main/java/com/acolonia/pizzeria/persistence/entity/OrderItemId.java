package com.acolonia.pizzeria.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor // <- Constructor vacío (obligatorio para JPA)
@AllArgsConstructor  // <- Constructor completo
public class OrderItemId implements Serializable {
    //llaves primarias
    private Integer idOrder;
    private Integer idItem;

    // Métodos equals() y hashCode() (obligatorios para claves compuestas)
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof OrderItemId that)) return false;
        return Objects.equals(idOrder, that.idOrder) && Objects.equals(idItem, that.idItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idItem);
    }
    /*
    ¿Cuándo se usa una clave primaria compuesta en JPA?
Una clave primaria compuesta se usa cuando una tabla necesita más de un campo para identificar
de manera única cada fila. Esto es común en tablas de relaciones muchos a muchos (M:N) o en tablas
 con dependencias jerárquicas.

 ¿Cuándo usar @IdClass vs. @EmbeddedId?
Característica	                                                  @IdClass	@EmbeddedId
Clave primaria compuesta	                                        ✅ Sí	✅ Sí
Los campos de la clave están como atributos normales en la entidad	✅ Sí	❌ No (se agrupan en un objeto)
Se usa en tablas intermedias o con relaciones	                    ✅ Sí	✅ Sí
Se usa cuando la clave primaria es parte de una relación @ManyToOne	✅ Sí	❌ No

    */

}
