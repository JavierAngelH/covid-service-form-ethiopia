package com.edgedx.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgedx.covid.model.LaboratoryDiagnosis;

@Repository
public interface LaboratoryDiagnosisRepository extends CrudRepository<LaboratoryDiagnosis,Integer>  {

	LaboratoryDiagnosis findByPatientId(Integer patientId);
	
}
