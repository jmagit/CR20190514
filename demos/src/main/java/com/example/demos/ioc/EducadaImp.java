package com.example.demos.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("Bien")
public class EducadaImp implements Educada {
	@Override
	public String saluda() { return "Hola Mundo"; }
}
