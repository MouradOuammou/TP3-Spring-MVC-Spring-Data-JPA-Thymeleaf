package tp3.c.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tp3.c.repository.PatientRepository;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
        public String index(Model model) {
        List<Patient> Listpatients = patientRepository.findAll();
        model.addAttribute("patients", Listpatients);
        return "patient";
        }

}
