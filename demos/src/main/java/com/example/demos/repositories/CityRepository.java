package com.example.demos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demos.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
