package com.example.demos.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country_id")
	private int countryId;

	@NonNull
	@Size(min=2, max = 50)
	private String country;

	@Column(name="last_update")
	@JsonIgnore
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="country")
	@JsonIgnore
	private List<City> cities;

	public Country() {
	}

	public Country(int countryId, String country) {
		this.countryId = countryId;
		this.country = country;
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setCountry(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setCountry(null);

		return city;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", country=" + country + "]";
	}
	@Autowired
	@Transient
	private Validator validator;

	public boolean isValid() {
//		ConstraintViolation<Country> constraintViolations =  (ConstraintViolation<Country>) validator.validate( this );
//		return constraintViolations.
		return true;
	}
	


}