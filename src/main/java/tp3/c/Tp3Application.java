package tp3.c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tp3.c.entites.Patient;
import tp3.c.repository.PatientRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp3Application implements ApplicationRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp3Application.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Patient> patients = Arrays.asList(
				Patient.builder().nom("Mohamed").dateNaissance(new Date(90, 0, 15)).malade(false).score(120).build(),
				Patient.builder().nom("Khalid").dateNaissance(new Date(85, 5, 22)).malade(true).score(80).build(),
				Patient.builder().nom("Younes").dateNaissance(new Date(75, 11, 3)).malade(false).score(150).build(),
				Patient.builder().nom("Anas").dateNaissance(new Date(75, 11, 3)).malade(false).score(150).build(),
				Patient.builder().nom("Walid").dateNaissance(new Date(95, 8, 14)).malade(true).score(65).build()
		);

		patientRepository.saveAll(patients);
	}
}
