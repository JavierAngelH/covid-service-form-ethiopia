package com.edgedx.covid.model;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class NationalityConverter implements AttributeConverter<Nationality, String> {

	@Override
	public String convertToDatabaseColumn(Nationality code) {
		if (code == null) {
			return null;
		}
		return code.getValue();
	}

	@Override
	public Nationality convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(Nationality.values()).filter(c -> c.getValue().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
