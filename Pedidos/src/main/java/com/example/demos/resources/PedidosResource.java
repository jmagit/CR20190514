package com.example.demos.resources;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/pedidos")
public class PedidosResource {
	
	@Autowired 
	RestTemplate srvRest;

	@GetMapping(path = "/clientes")
	public ClienteCompleto getAlgo() {
		ClienteCompleto rslt = srvRest.getForObject( 
				"http://localhost:4200/api/clientes/{id}?projection=clienteCompleto", 
				ClienteCompleto.class, 1);
		return rslt;

	}
	
}
