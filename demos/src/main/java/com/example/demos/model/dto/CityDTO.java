package com.example.demos.model.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.example.demos.model.City;
import com.example.demos.model.Country;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Ciudades", description = "Ciudades con el identificador de pais.")
public class CityDTO implements Serializable {
	@ApiModelProperty("Identificador de ciudad")
	private int cityId;
	@Size(min=2, max=50)
	@ApiModelProperty(notes = "Nombre de la ciudad, de 2 a 50 caracteres", required = true)
	private String city;
	@ApiModelProperty(notes = "Código del pais", required = false)
	private int countryId;

	public static CityDTO from(City source) {
		return new CityDTO(source.getCityId(), 
				source.getCity(), 
				source.getCountry() == null ? -1 : source.getCountry().getCountryId());
	}
	public static City from(@Valid CityDTO source) {
		return new City(source.getCityId(), 
				source.getCity(), 
				source.getCountryId() == -1 ? null: new Country(source.getCountryId(), null));
	}
}












