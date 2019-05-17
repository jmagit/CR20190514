package com.example.demos.model.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.demos.model.Customer;

@Projection(name = "clienteCorto", types = { Customer.class }) 
public interface ClienteCorto {
	int getCustomerId();
	String getFirstName();
	String getLastName();

}
