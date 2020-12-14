package com.edgedx.covid.model;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class ReasonTypeConverter implements AttributeConverter<BinaryOption, Integer> {

	@Override
	public Integer convertToDatabaseColumn(BinaryOption code) {
		if (code == null) {
			return null;
		}
		return code.getCode();
	}

	@Override
	public BinaryOption convertToEntityAttribute(Integer code) {
		if (code == null) {
			return null;
		}

		return Stream.of(BinaryOption.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
