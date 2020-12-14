package com.edgedx.covid.model;

public enum TestingReason {
	SARI(1, "SARI/Pnemonia"), 
	SUSPECT(2, "Suspect"),
	CONTACT(3, "Contact"),
	DISCHARGE_FROM_QUARANTINE(4, "Discharge from quarantine"),
	CLINICAL_DECISION(5, "Clinical decision"),
	FOLLOWUP_1(6, "Followup 1"),
	FOLLOWUP_2(7, "Followup 2"),
	FOLLOWUP_3(8, "Followup 3"),
	COMMUNITY_SURVEILLANCE(9, "Community surveillance");


	private final int code;

	private final String description;

	public static TestingReason findByCode(int code) {
		switch (code) {
		case 1:
			return TestingReason.SARI;
		case 2:
			return TestingReason.SUSPECT;
		case 3:
			return TestingReason.CONTACT;
		case 4:
			return TestingReason.DISCHARGE_FROM_QUARANTINE;
		case 5:
			return TestingReason.CLINICAL_DECISION;
		case 6:
			return TestingReason.FOLLOWUP_1;
		case 7:
			return TestingReason.FOLLOWUP_2;
		case 8:
			return TestingReason.FOLLOWUP_3;
		case 9:
			return TestingReason.COMMUNITY_SURVEILLANCE;
		default:
			return null;
		}
	}

	private TestingReason(int code, String description) {
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
