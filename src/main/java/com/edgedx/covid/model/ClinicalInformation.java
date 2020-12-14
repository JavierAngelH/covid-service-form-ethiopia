package com.edgedx.covid.model;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "covid_clinical_information")
public class ClinicalInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer patientId;
	
	@Convert(converter = BinaryOptionConverter.class)
	private BinaryOption patientTravelled;
	
	@Convert(converter = CountryConverter.class)
	private Country country;

	private String city;
	
	private LocalDate returnDate;
	@Convert(converter = TestingReasonConverter.class)
	private TestingReason reasonForTesting;
	
	private String requestingPhysician;
	
	private String requestingPhone;

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

	public BinaryOption getPatientTravelled() {
		return patientTravelled;
	}

	public void setPatientTravelled(BinaryOption patientTravelled) {
		this.patientTravelled = patientTravelled;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public TestingReason getReasonForTesting() {
		return reasonForTesting;
	}

	public void setReasonForTesting(TestingReason reasonForTesting) {
		this.reasonForTesting = reasonForTesting;
	}

	public String getRequestingPhysician() {
		return requestingPhysician;
	}

	public void setRequestingPhysician(String requestingPhysician) {
		this.requestingPhysician = requestingPhysician;
	}

	public String getRequestingPhone() {
		return requestingPhone;
	}

	public void setRequestingPhone(String requestingPhone) {
		this.requestingPhone = requestingPhone;
	}

	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public ClinicalInformation(Integer id, Integer patientId, BinaryOption patientTravelled, String city, LocalDate returnDate,
			TestingReason reasonForTesting, String requestingPhysician, String requestingPhone) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.patientTravelled = patientTravelled;
		this.city = city;
		this.returnDate = returnDate;
		this.reasonForTesting = reasonForTesting;
		this.requestingPhysician = requestingPhysician;
		this.requestingPhone = requestingPhone;
	}

	public ClinicalInformation() {
		super();
	}
	
	


}
