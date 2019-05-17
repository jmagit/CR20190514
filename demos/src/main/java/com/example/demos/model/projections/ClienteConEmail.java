package com.example.demos.model.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.demos.model.Customer;

@Projection(name = "clienteConEmail", types = { Customer.class }) 
public interface ClienteConEmail {
	int getCustomerId();
	String getEmail();
}
