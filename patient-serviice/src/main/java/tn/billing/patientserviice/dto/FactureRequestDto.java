package tn.billing.patientserviice.dto;



import java.time.LocalDate;


public record FactureRequestDto(Long id, String patientId, double amount, LocalDate dateFacture) {}
