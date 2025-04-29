package tn.billing.patientserviice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.billing.patientserviice.entities.Patient;

import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String> {
    Optional<Patient> findByEmail(String email);
}
