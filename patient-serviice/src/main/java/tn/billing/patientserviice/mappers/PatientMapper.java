package tn.billing.patientserviice.mappers;

import org.mapstruct.Mapper;
import tn.billing.patientserviice.dto.PatientDto;
import tn.billing.patientserviice.entities.Patient;


@Mapper(componentModel = "spring")

public interface PatientMapper {
    Patient mapToEntity(PatientDto dto);
    PatientDto mapToDto(Patient patient);


}
