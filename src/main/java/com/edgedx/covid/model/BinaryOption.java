package com.edgedx.covid.model;


public enum BinaryOption {
	NO(0, "No"), 
	YES(1, "Yes");

	private final int code;

	private final String description;

	public static BinaryOption findByCode(int code) {
		switch (code) {
		case 0:
			return BinaryOption.NO;
		case 1:
			return BinaryOption.YES;
		default:
			return null;
		}
	}

	private BinaryOption(int code, String description) {
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
