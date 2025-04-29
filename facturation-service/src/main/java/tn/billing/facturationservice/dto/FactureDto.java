package tn.billing.facturationservice.dto;


import java.time.LocalDate;

public record FactureDto(Long id, String patientId, double amount, LocalDate dateFacture) {}
