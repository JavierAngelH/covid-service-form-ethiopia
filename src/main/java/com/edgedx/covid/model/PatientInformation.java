package com.edgedx.covid.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "covid_patient_information")
public class PatientInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String fullName;
	
	private Sex sex;
	
	private Integer age;
	
	private Nationality nationality;
	
	private String phoneNumber;
	
	private String passportNumber;
	
	private String residenceCity;
	
	private String region;
	
	private String specimenCollectionLocation;
	
	private String specimenId;
	
	@JsonIgnore
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> images;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSpecimenCollectionLocation() {
		return specimenCollectionLocation;
	}

	public void setSpecimenCollectionLocation(String specimenCollectionLocation) {
		this.specimenCollectionLocation = specimenCollectionLocation;
	}

	public String getSpecimenId() {
		return specimenId;
	}

	public void setSpecimenId(String specimenId) {
		this.specimenId = specimenId;
	}
	
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public PatientInformation(Integer id, String fullName, Sex sex, Integer age, Nationality nationality,
			String phoneNumber, String passportNumber, String residenceCity, String region,
			String specimenCollectionLocation, String specimenId) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.sex = sex;
		this.age = age;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.passportNumber = passportNumber;
		this.residenceCity = residenceCity;
		this.region = region;
		this.specimenCollectionLocation = specimenCollectionLocation;
		this.specimenId = specimenId;
	}

	public PatientInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
