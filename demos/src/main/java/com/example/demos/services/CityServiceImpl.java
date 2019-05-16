package com.example.demos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demos.model.City;
import com.example.demos.repositories.CityRepository;
import com.example.demos.services.contract.CityService;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository dao;
	
	@Override
	public List<City> getAll() {
		return dao.findAll();
	}
	
	@Override
	public Optional<City> get(int id) {
		return dao.findById(id);
	}
	
	@Override
	public void add(City item) throws Exception {
		if(get(item.getCityId()).isPresent())
			throw new Exception("Ya existe");
		dao.save(item);
	}
	@Override
	public void modify(City item) throws Exception {
		if(!get(item.getCityId()).isPresent())
			throw new Exception("Elemento no encontrado");
		dao.save(item);
	}
	@Override
	public void delete(int id) {
		dao.deleteById(id);
	}
	@Override
	public void delete(City item) {
		delete(item.getCityId());
	}
}
