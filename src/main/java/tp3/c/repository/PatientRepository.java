package tp3.c.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp3.c.entites.Patient;

public interface PatientRepository  extends JpaRepository<Patient ,Long> {
}
