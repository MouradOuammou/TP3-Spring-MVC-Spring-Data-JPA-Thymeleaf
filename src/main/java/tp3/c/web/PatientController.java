package tp3.c.web;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tp3.c.entites.Patient;
import tp3.c.repository.PatientRepository;

@Controller
@AllArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @GetMapping("/patients")
    public String patients(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int pageSize,
                        @RequestParam(defaultValue = "") String keyword)
    {
        Page<Patient> patientPage = patientRepository.findByNomContains(keyword, PageRequest.of(page, pageSize));
        model.addAttribute("patients", patientPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", patientPage.getTotalPages());
        model.addAttribute("totalPatients", patientPage.getTotalElements());
        return "patients";
    }
}
