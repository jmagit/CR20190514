package com.example.demos.services.contract;

import java.util.List;
import java.util.Optional;

import com.example.demos.model.City;

public interface CityService {

	List<City> getAll();

	Optional<City> get(int id);

	void add(City item) throws Exception;

	void modify(City item) throws Exception;

	void delete(int id);

	void delete(City item);

}