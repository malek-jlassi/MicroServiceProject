package tn.billing.patientserviice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public record FactureRequestDto(Long id, String patientId, double amount, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate dateFacture) {}
