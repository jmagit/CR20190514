package com.example.demos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demos.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	List<Country> findByCountryStartingWithOrderByCountryDesc(String prefijo);
}
