package com.example.demos.resources;

import java.util.Date;

import lombok.Data;

@Data
public class ClienteCompleto {
	private int customerId;
	private byte active;
	private Date createDate;
	private String email;
	private String firstName;
	private String lastName;
}
