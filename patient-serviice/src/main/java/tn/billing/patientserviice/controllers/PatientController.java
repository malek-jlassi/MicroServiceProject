package tn.billing.patientserviice.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import tn.billing.patientserviice.dto.FactureRequestDto;
import tn.billing.patientserviice.dto.PatientDto;
import tn.billing.patientserviice.feignClients.FactureClient;
import tn.billing.patientserviice.services.IPatientService;

import java.time.LocalDate;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor

public class PatientController {


    private final IPatientService service;
    private final FactureClient factureClient;
    @Value("${custom.message}")
    private String customMessage;

    @PostMapping()
    public PatientDto add(@RequestBody PatientDto dto) {
        return service.add(dto);
    }

    @GetMapping("/{id}")
    public PatientDto get(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<PatientDto> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @PostMapping("/{id}/pay")
    public FactureRequestDto payBill(@PathVariable String id, @RequestParam double amount) {
        // 1. Verify the patient exists
        PatientDto patient = service.getById(id);

        // 2. Create the facture
        FactureRequestDto facture = new FactureRequestDto(null, id, amount, LocalDate.now());

        // 3. Send to facture-service using Feign
        return factureClient.addFacture(facture);
    }

    @GetMapping("/message")
    public String getMessage() {
        return customMessage;
    }
}
