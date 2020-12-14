package com.edgedx.covid.model;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class TestingReasonConverter implements AttributeConverter<TestingReason, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TestingReason code) {
		if (code == null) {
			return null;
		}
		return code.getCode();
	}

	@Override
	public TestingReason convertToEntityAttribute(Integer code) {
		if (code == null) {
			return null;
		}

		return Stream.of(TestingReason.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
