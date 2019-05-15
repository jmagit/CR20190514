package com.example.demos;

import java.util.Optional;
import java.util.stream.Stream;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jca.cci.core.support.CciDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.example.demos.ioc.Educada;
import com.example.demos.ioc.Linea;
import com.example.demos.ioc.Punto;
import com.example.demos.model.City;
import com.example.demos.model.Country;
import com.example.demos.model.dto.CityDTO;
import com.example.demos.repositories.CityRepository;
import com.example.demos.repositories.CountryRepository;

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
	
	@Value("${mi.valor}")
	private String cotilla;

	@Autowired
	private CountryRepository dao, dao2;
	@Autowired
	private CityRepository cityDao;
	
	@Override
	public void run(String... args) throws Exception {
		Optional<Country> rslt = dao.findById(10);
		if( rslt.isPresent())
			System.out.println(rslt.get().getCountry());
		Stream<Country> lst = dao.findByCountryStartingWithOrderByCountryDesc("S").stream();
		
		lst.forEach(item -> System.out.println(item.getCountry()));
		
		Stream<CityDTO> cc = cityDao.findAll().stream().map(item -> CityDTO.from(item));
		cc.forEach(item -> System.out.println(item));
		
//		City city = CityDTO.from(new CityDTO());
//		Country country = new Country(1111, null);
//		country.isValid();
//		dao.save(country);
		try {
//			miTrn();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Transactional
	private void miTrn()  {
		dao.deleteAll();
		dao2.deleteAll();
		
	}
	public void demoIOC(String... args) throws Exception {
		System.out.println(linea);
		System.out.println(punto);
		punto.setX(10);
		System.out.println(punto2);
		System.out.println(educada.saluda());
		System.out.println(cotilla);
	}

}
