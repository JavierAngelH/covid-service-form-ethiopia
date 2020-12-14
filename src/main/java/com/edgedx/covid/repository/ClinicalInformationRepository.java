package com.edgedx.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgedx.covid.model.ClinicalInformation;

@Repository
public interface ClinicalInformationRepository extends CrudRepository<ClinicalInformation,Integer> {

	ClinicalInformation findByPatientId(Integer patientId);
	
}
