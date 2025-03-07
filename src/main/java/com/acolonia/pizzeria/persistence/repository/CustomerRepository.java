package com.acolonia.pizzeria.persistence.repository;

import com.acolonia.pizzeria.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {

    //uso de JPQL para realizar consultas a la base de datos
    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phone")
    CustomerEntity findByPhone (@Param("phone") String phone);

}
