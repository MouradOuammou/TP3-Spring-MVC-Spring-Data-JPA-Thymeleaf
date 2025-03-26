package tp3.c.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp3.c.entites.Patient;

public interface PatientRepository  extends JpaRepository<Patient ,Long> {

    Page<Patient> findByNameContains(String keyword, Pageable pageable);
}
