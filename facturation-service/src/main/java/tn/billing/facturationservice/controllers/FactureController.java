package tn.billing.facturationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import tn.billing.facturationservice.dto.FactureDto;
import tn.billing.facturationservice.services.IFactureService;

import java.util.List;
@RefreshScope
@RestController
@RequestMapping("/factures")
@RequiredArgsConstructor
public class FactureController {



    private final IFactureService factureService;


    @Value("${custom.message}")
    private String customMessage;


    @PostMapping
    public FactureDto add(@RequestBody FactureDto dto) {
        return factureService.add(dto);
    }

    @GetMapping("/patient/{patientId}")
    public List<FactureDto> getByPatient(@PathVariable String patientId) {
        return factureService.getByPatient(patientId);
    }

    @GetMapping("/message")
    public String getMessage() {
        return customMessage;
    }
}
