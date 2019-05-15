package com.example.demos.ioc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demos.DemosApplication;

@Component
public class Linea {
	@Autowired
	private Punto ini, fin;
	
	public Linea() {
		//String s = ini.toString();
	}
	
	@PostConstruct
	public void demo() {
		ini.setX(123);
		ini.setY(456);
	}

	@Override
	public String toString() {
		return "Linea [ini=" + ini + ", fin=" + fin + "]";
	}
	
}
