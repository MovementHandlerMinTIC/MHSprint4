package co.mintic.mh.moventHandler.controller;

import co.mintic.mh.moventHandler.entities.Empleado;
import co.mintic.mh.moventHandler.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class IndexController {
    private final Logger LOG = Logger.getLogger(""+IndexController.class);
    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/")
    public String login(Model model,@AuthenticationPrincipal OidcUser principal){
        if (principal  != null) {
            Empleado empleado = empleadoService.getOrCreateEmpleado(principal.getClaims());
            System.out.println(empleado);
            model.addAttribute("empleado",empleado);
        }
        return "login";
    }

    @GetMapping("/index/{id}")
    public String index(@PathVariable Long id, Model model){
        Optional<Empleado> empleado = empleadoService.findById(id);
        model.addAttribute("empleado",empleado.get());
        return "index";
    }

}
