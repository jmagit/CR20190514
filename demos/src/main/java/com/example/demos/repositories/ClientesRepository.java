package com.example.demos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demos.model.Customer;
import com.example.demos.model.projections.ClienteCompleto;

@RepositoryRestResource(path="clientes", 
	itemResourceRel="cliente", 
	collectionResourceRel="clientes",
	excerptProjection = ClienteCompleto.class)
public interface ClientesRepository extends JpaRepository<Customer, Integer> {

}
