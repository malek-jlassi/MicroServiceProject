package tn.billing.facturationservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.billing.facturationservice.entities.Facture;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    List<Facture> findByPatientId(String patientId);
}
