package tn.billing.patientserviice.feignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.billing.patientserviice.dto.FactureRequestDto;

import java.util.List;

@FeignClient(name = "facturation-service", url = "http://localhost:8585/facture")
public interface FactureClient {

    @PostMapping("/factures")
    FactureRequestDto addFacture(@RequestBody FactureRequestDto factureRequest);

    @GetMapping("/factures/patient/{patientId}")
    List<FactureRequestDto> getFacturesByPatient(@PathVariable("patientId") String patientId);
}