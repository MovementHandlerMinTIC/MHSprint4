package co.mintic.mh.moventHandler.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class IndexController {
    private final Logger LOG = Logger.getLogger(""+IndexController.class);

    //@GetMapping("/")
    //public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        //if (principal !=null) {

        //}
      //  return "login";
    //}

    @GetMapping("/")
    public String login(Model model,@AuthenticationPrincipal OidcUser principal){
        LOG.log(Level.INFO,"index");
        var mensaje = "Bienvenidos al sistema de gestión de ingresos y egresos ";
        model.addAttribute("mensaje", mensaje);
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model){
        LOG.log(Level.INFO,"index");
        var mensaje = "Bienvenidos al sistema de gestión de ingresos y egresos ";
        model.addAttribute("mensaje", mensaje);
        return "index";
    }

}
