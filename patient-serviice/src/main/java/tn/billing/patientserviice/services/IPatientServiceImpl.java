package tn.billing.patientserviice.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.billing.patientserviice.dto.PatientDto;
import tn.billing.patientserviice.entities.Patient;
import tn.billing.patientserviice.mappers.PatientMapper;
import tn.billing.patientserviice.repositories.PatientRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class IPatientServiceImpl implements IPatientService {


    public final PatientRepository patientRepository;
    public final PatientMapper patientMapper;

    @Override
    public PatientDto add(PatientDto dto) {
        Patient p = patientMapper.mapToEntity(dto);
        p.setCreatedAt(LocalDateTime.now());
        return patientMapper.mapToDto(patientRepository.save(p));
    }

    @Override
    public PatientDto getById(String id) {
        return patientRepository.findById(id).map(patientMapper::mapToDto)
                .orElseThrow(() -> new IllegalArgumentException("Not found"));

    }

    @Override
    public List<PatientDto> getAll() {
        return patientRepository.findAll().stream().map(patientMapper::mapToDto).toList();
    }

    @Override
    public boolean delete(String id) {
        patientRepository.deleteById(id);
        return !patientRepository.existsById(id);
    }
}
