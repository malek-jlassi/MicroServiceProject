package tn.billing.facturationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.billing.facturationservice.dto.FactureDto;
import tn.billing.facturationservice.services.IFactureService;

import java.util.List;

@RestController
@RequestMapping("/factures")
@RequiredArgsConstructor
public class FactureController {

    private final IFactureService factureService;

    @PostMapping
    public FactureDto add(@RequestBody FactureDto dto) {
        return factureService.add(dto);
    }

    @GetMapping("/patient/{patientId}")
    public List<FactureDto> getByPatient(@PathVariable String patientId) {
        return factureService.getByPatient(patientId);
    }
}
