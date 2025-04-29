package tn.billing.facturationservice.services;

import tn.billing.facturationservice.dto.FactureDto;

import java.util.List;

public interface IFactureService {

    FactureDto add(FactureDto dto);
    List<FactureDto> getByPatient(String patientId);


}
