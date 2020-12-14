package com.edgedx.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgedx.covid.model.SpecimenInformation;

@Repository
public interface SpecimenInformationRepository extends CrudRepository<SpecimenInformation,Integer> {

	SpecimenInformation findByPatientId(Integer patientId);
	
}
