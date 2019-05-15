package com.example.demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demos.ioc.Educada;
import com.example.demos.ioc.Linea;
import com.example.demos.ioc.Punto;

@SpringBootApplication
public class DemosApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemosApplication.class, args);
	}
	
	@Bean
	public Punto myPunto() {
		return new Punto(2,1);
	}
	@Autowired
	private Punto punto;
	@Autowired
	private Punto punto2;
	
	@Autowired
	@Qualifier("Mal")
	private Educada educada;
	
	@Autowired 
	private Linea linea;
	
	@Value("${spring.datasource.url}")
	private String cotilla;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(linea);
		System.out.println(punto);
		punto.setX(10);
		System.out.println(punto2);
		System.out.println(educada.saluda());
		System.out.println(cotilla);
	}

}
