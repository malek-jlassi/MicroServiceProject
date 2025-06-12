package tn.billing.facturationservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import tn.billing.facturationservice.dto.FactureDto;
import tn.billing.facturationservice.mappers.FactureMapper;
import tn.billing.facturationservice.repositories.FactureRepository;

import java.util.List;

@RefreshScope
@Service
@RequiredArgsConstructor
public class IFactureServiceImpl implements IFactureService {

    private final FactureRepository factureRepository;
    private final FactureMapper factureMapper;

    @Value("${custom.message}")
    private String customMessage;

    public String getMessage() {
        return customMessage;
    }
    @Override
    public FactureDto add(FactureDto dto) {
        return factureMapper.mapToDto(factureRepository.save(factureMapper.mapToEntity(dto)));
    }

    @Override
    public List<FactureDto> getByPatient(String patientId) {
        return factureRepository.findByPatientId(patientId).stream().map(factureMapper::mapToDto).toList();
    }
}
