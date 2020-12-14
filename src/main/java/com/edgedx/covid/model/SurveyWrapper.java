package com.edgedx.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveyWrapper {

	PatientInformation patientInformation;
	
	SpecimenInformation specimenInformation;
	
	ClinicalInformation clinicalInformation;
	
	LaboratoryDiagnosis laboratoryDiagnosis;

	public PatientInformation getPatientInformation() {
		return patientInformation;
	}

	public void setPatientInformation(PatientInformation patientInformation) {
		this.patientInformation = patientInformation;
	}

	public SpecimenInformation getSpecimenInformation() {
		return specimenInformation;
	}

	public void setSpecimenInformation(SpecimenInformation specimenInformation) {
		this.specimenInformation = specimenInformation;
	}

	public ClinicalInformation getClinicalInformation() {
		return clinicalInformation;
	}

	public void setClinicalInformation(ClinicalInformation clinicalInformation) {
		this.clinicalInformation = clinicalInformation;
	}

	public LaboratoryDiagnosis getLaboratoryDiagnosis() {
		return laboratoryDiagnosis;
	}

	public void setLaboratoryDiagnosis(LaboratoryDiagnosis laboratoryDiagnosis) {
		this.laboratoryDiagnosis = laboratoryDiagnosis;
	}

	public SurveyWrapper(PatientInformation patientInformation, SpecimenInformation specimenInformation,
			ClinicalInformation clinicalInformation, LaboratoryDiagnosis laboratoryDiagnosis) {
		super();
		this.patientInformation = patientInformation;
		this.specimenInformation = specimenInformation;
		this.clinicalInformation = clinicalInformation;
		this.laboratoryDiagnosis = laboratoryDiagnosis;
	}

	public SurveyWrapper() {
		super();
	}
	
	
}
