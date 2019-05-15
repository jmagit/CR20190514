package com.example.demos.model.dto;

import java.io.Serializable;

import com.example.demos.model.City;
import com.example.demos.model.Country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO implements Serializable {
	private int cityId;
	private String city;
	private int countryId;

	public static CityDTO from(City source) {
		return new CityDTO(source.getCityId(), 
				source.getCity(), 
				source.getCountry() == null ? -1 : source.getCountry().getCountryId());
	}
	public static City from(CityDTO source) {
		return new City(source.getCityId(), 
				source.getCity(), 
				source.getCountryId() == -1 ? null: new Country(source.getCountryId(), null));
	}
}












