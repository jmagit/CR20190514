package com.example.demos.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demos.exceptions.NotFoundException;
import com.example.demos.model.City;
import com.example.demos.model.Country;
import com.example.demos.model.dto.CityDTO;
import com.example.demos.repositories.CityRepository;
import com.example.demos.repositories.CountryRepository;
import com.example.demos.services.contract.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/ciudades")
@Api(value = "Mantenimiento de Ciudades", description = "API que permite el mantenimiento de ciudades")
public class CityResource {
	@Autowired
	private CityService srv;
	
	@GetMapping
	private List<CityDTO> getAll() {
		return srv.getAll().stream().map(item -> CityDTO.from(item)).collect(Collectors.toList());
	}
	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Buscar una ciudad", notes = "Devuelve una ciudad por su identificador" )
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ciudad encontrada"),
		@ApiResponse(code = 404, message = "Ciudad no encontrada")
	})
	private CityDTO getOne(@PathVariable int id) throws Exception {
		Optional<City> rslt = srv.get(id);
		if(rslt.isPresent())
			return CityDTO.from(rslt.get());
		throw new NotFoundException();
	}
	@GetMapping(path = "/{id}/pais")
	private Country getPais(@PathVariable int id) throws Exception {
		Optional<City> rslt = srv.get(id);
		if(rslt.isPresent())
			return rslt.get().getCountry();
		throw new NotFoundException();
	}
	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> create(@Valid @RequestBody CityDTO item) throws Exception {
		City newItem = CityDTO.from(item);
		srv.add(newItem);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newItem.getCityId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void modify(@PathVariable int id, @RequestBody CityDTO item) throws Exception {
		srv.modify(CityDTO.from(item));
	}
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void create(@PathVariable int id) throws Exception {
		srv.delete(id);
	}

	@Autowired
	private CountryRepository dao;
	
	@GetMapping("/paises")
	private List<Country> getPaises() {
		return dao.findAll();
	}
	@Autowired
	private CityRepository kk;
	
	@GetMapping("/kk")
	private List<City> getKK() {
		return kk.findAll();
	}
	
	
}
