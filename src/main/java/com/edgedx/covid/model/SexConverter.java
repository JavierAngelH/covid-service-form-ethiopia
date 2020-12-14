package com.edgedx.covid.model;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class SexConverter implements AttributeConverter<Sex, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Sex code) {
		if (code == null) {
			return null;
		}
		return code.getCode();
	}

	@Override
	public Sex convertToEntityAttribute(Integer code) {
		if (code == null) {
			return null;
		}

		return Stream.of(Sex.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
