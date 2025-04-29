package tn.billing.facturationservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String patientId; // references MongoDB patient
    double amount;
    LocalDate dateFacture;


}
