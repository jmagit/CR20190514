package com.example.demos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demos.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
