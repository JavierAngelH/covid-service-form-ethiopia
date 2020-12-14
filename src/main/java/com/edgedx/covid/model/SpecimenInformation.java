package com.edgedx.covid.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "covid_specimen_information")
public class SpecimenInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer patientId;

	private String sampleType;

	private LocalDate receivedLabDate;

	private String sampleCollectedBy;

	private String collectorPhone;

	private LocalDateTime specimenCollectionTime;

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

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public LocalDate getReceivedLabDate() {
		return receivedLabDate;
	}

	public void setReceivedLabDate(LocalDate receivedLabDate) {
		this.receivedLabDate = receivedLabDate;
	}

	public String getSampleCollectedBy() {
		return sampleCollectedBy;
	}

	public void setSampleCollectedBy(String sampleCollectedBy) {
		this.sampleCollectedBy = sampleCollectedBy;
	}

	public String getCollectorPhone() {
		return collectorPhone;
	}

	public void setCollectorPhone(String collectorPhone) {
		this.collectorPhone = collectorPhone;
	}

	public LocalDateTime getSpecimenCollectionTime() {
		return specimenCollectionTime;
	}

	public void setSpecimenCollectionTime(LocalDateTime specimenCollectionTime) {
		this.specimenCollectionTime = specimenCollectionTime;
	}

	public SpecimenInformation(Integer id, Integer patientId, String sampleType, LocalDate receivedLabDate,
			String sampleCollectedBy, String collectorPhone, LocalDateTime specimenCollectionTime) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.sampleType = sampleType;
		this.receivedLabDate = receivedLabDate;
		this.sampleCollectedBy = sampleCollectedBy;
		this.collectorPhone = collectorPhone;
		this.specimenCollectionTime = specimenCollectionTime;
	}

	public SpecimenInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
