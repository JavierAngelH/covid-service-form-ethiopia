package com.edgedx.covid.model;


public enum ReasonType {
	NEW(1, "New"), 
	REPEAT(2, "Repeat");

	private final int code;

	private final String description;

	public static ReasonType findByCode(int code) {
		switch (code) {
		case 1:
			return ReasonType.NEW;
		case 2:
			return ReasonType.REPEAT;
		default:
			return null;
		}
	}

	private ReasonType(int code, String description) {
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
