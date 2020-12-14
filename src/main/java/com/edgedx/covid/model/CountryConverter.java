package com.edgedx.covid.model;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CountryConverter implements AttributeConverter<Country, String> {

	@Override
	public String convertToDatabaseColumn(Country country) {
		if (country == null) {
			return null;
		}
		return country.getCountryName();
	}

	@Override
	public Country convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(Country.values()).filter(c -> c.getCountryName().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
