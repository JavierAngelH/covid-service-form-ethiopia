package com.edgedx.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgedx.covid.model.PatientInformation;

@Repository
public interface PatientInformationRepository extends CrudRepository<PatientInformation,Integer> {

	PatientInformation findBySpecimenId(String specimenId);
	
	
}
