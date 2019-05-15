package com.example.demos.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("Mal")
public class MalEducada implements Educada {

	@Override
	public String saluda() {
		return "Que pasa tio";
	}

}
