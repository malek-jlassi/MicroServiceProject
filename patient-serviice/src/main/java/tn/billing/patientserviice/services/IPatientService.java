package tn.billing.patientserviice.services;

import tn.billing.patientserviice.dto.PatientDto;

import java.util.List;

public interface IPatientService {

    PatientDto add(PatientDto dto);
    PatientDto getById(String id);
    List<PatientDto> getAll();
    boolean delete(String id);
}
