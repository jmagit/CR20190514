package com.example.demos.model.projections;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.example.demos.model.Customer;

@Projection(name = "clienteCompleto", types = { Customer.class }) 
public interface ClienteCompleto {

	int getCustomerId();

	byte getActive();

	Date getCreateDate();

	String getEmail();

	String getFirstName();

	String getLastName();

}