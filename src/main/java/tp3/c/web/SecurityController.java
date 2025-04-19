package tp3.c.web;

import org.springframework.web.bind.annotation.GetMapping;

public class SecurityController {
    @GetMapping("/notAuthorized")
    public String notAuthorized(){
       return "not authorized";
    }
}
