package tn.billing.patientserviice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PatientServiiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientServiiceApplication.class, args);
	}

}
