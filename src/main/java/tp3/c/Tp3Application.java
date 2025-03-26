package tp3.c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tp3.c.entites.Patient;
import tp3.c.repository.PatientRepository;

import java.util.Date;

@SpringBootApplication
public class Tp3Application implements ApplicationRunner {
	@Autowired
	private PatientRepository patientRepository;


	public static void main(String[] args) {
		SpringApplication.run(Tp3Application.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		Patient patient = Patient.builder()
				.name("")
				.dateDeNaissance(new Date())
				.malade(false)
				.score(0)
				.build();

		patientRepository.save(patient);

	}
}
