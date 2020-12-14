package com.edgedx.covid.model;


public enum Sex {
	MALE(1, "Male"), 
	FEMALE(2, "Female");

	private final int code;

	private final String description;

	public static Sex findByCode(int code) {
		switch (code) {
		case 1:
			return Sex.MALE;
		case 2:
			return Sex.FEMALE;
		default:
			return null;
		}
	}

	private Sex(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
	

}
