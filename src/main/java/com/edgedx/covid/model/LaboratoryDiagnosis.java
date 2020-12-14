package com.edgedx.covid.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "covid_laboratory_diagnosis")
public class LaboratoryDiagnosis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer patientId;
	
	private String testRequested;
	
	private String testMethod;
	
	private String labResult;
	
	private String testDoneBy;
	
	private LocalDate diagnosisDate;
	
	private String resultApprovedBy;
	
	private LocalDate approvedDate;
	
	private String testProtocol;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getTestRequested() {
		return testRequested;
	}

	public void setTestRequested(String testRequested) {
		this.testRequested = testRequested;
	}

	public String getTestMethod() {
		return testMethod;
	}

	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}

	public String getLabResult() {
		return labResult;
	}

	public void setLabResult(String labResult) {
		this.labResult = labResult;
	}

	public String getTestDoneBy() {
		return testDoneBy;
	}

	public void setTestDoneBy(String testDoneBy) {
		this.testDoneBy = testDoneBy;
	}

	public LocalDate getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(LocalDate diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public String getResultApprovedBy() {
		return resultApprovedBy;
	}

	public void setResultApprovedBy(String resulApprovedBy) {
		this.resultApprovedBy = resulApprovedBy;
	}

	public LocalDate getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDate approvedDate) {
		this.approvedDate = approvedDate;
	}
	
	

	public String getTestProtocol() {
		return testProtocol;
	}

	public void setTestProtocol(String testProtocol) {
		this.testProtocol = testProtocol;
	}

	public LaboratoryDiagnosis(Integer id, Integer patientId, String testRequested, String testMethod, String labResult,
			String testDoneBy, LocalDate diagnosisDate, String resulApprovedBy, LocalDate approvedDate) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.testRequested = testRequested;
		this.testMethod = testMethod;
		this.labResult = labResult;
		this.testDoneBy = testDoneBy;
		this.diagnosisDate = diagnosisDate;
		this.resultApprovedBy = resulApprovedBy;
		this.approvedDate = approvedDate;
	}

	public LaboratoryDiagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
