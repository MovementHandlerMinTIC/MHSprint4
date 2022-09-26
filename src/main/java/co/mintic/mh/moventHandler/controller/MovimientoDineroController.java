package co.mintic.mh.moventHandler.controller;

import co.mintic.mh.moventHandler.entities.Empleado;
import co.mintic.mh.moventHandler.entities.MovimientodeDinero;
import co.mintic.mh.moventHandler.services.IEmpleadoService;
import co.mintic.mh.moventHandler.services.IEmpresaService;
import co.mintic.mh.moventHandler.services.IMovimientodeDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MovimientoDineroController {

    @Autowired
    private IMovimientodeDineroService movimientoDineroService;

    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IEmpleadoService empleadoService;



    @GetMapping("/VerMovimientos")
    public String viewMovimientoDinero(@ModelAttribute("mensaje") String mensaje, Model model)  {
        List<MovimientodeDinero> listamovimientos = movimientoDineroService.findAll();
        model.addAttribute("movlist",listamovimientos);
        model.addAttribute("mensaje",mensaje);
        return "verMovimientos";

    }

    @GetMapping("/AgregarMovimiento")
    public String nuevoMovimientoDinero(@ModelAttribute("mensaje") String mensaje,Model model){
        MovimientodeDinero movimiento = new MovimientodeDinero();
        model.addAttribute("mov",movimiento);
        model.addAttribute("mensaje",mensaje);
        List<Empleado> listaEmpleados = empleadoService.findAll();
        model.addAttribute("emplelist",listaEmpleados);
        return "agregarMovimiento";
    }

    @PostMapping("/GuardarMovimiento")
    public String guardarMovimientoDinero(MovimientodeDinero mov, RedirectAttributes redirectAttributes){
        if(movimientoDineroService.createMovimientodeDinero(mov)){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveNOOK");
        return "redirect:/AgregarMovimiento";
    }

    @GetMapping("/EditarMovimiento/{id}")
    public String editarMovimientoDinero(@ModelAttribute("mensaje") String mensaje,Model model,@PathVariable Long id) {
        MovimientodeDinero mov = movimientoDineroService.findById(id).get();
        model.addAttribute("mov",mov);
        model.addAttribute("mensaje",mensaje);
        List<Empleado> listaempleados = empleadoService.findAll();
        model.addAttribute("emplelist",listaempleados);
        return "editarMovimiento";
    }


    @PostMapping("/ActualizarMovimiento")
    public String actualizarMovimientoDinero(@ModelAttribute("mov") String mensaje, MovimientodeDinero mov, RedirectAttributes redirectAttributes){
        if(movimientoDineroService.updateMovimientodeDinero(mov)==true){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarMovimiento/"+mov.getConceptoTransaccion();
    }

    @GetMapping("/EliminarMovimiento/{id}")
    public String eliminarMovimientoDinero(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (movimientoDineroService.deleteMovimientodeDinero(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientos";

    }



}
