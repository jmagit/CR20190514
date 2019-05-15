package com.example.demos.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Linea {
	@Autowired
	private Punto ini, fin;

	@Override
	public String toString() {
		return "Linea [ini=" + ini + ", fin=" + fin + "]";
	}
	
}
