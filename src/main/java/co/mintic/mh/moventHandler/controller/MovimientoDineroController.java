package co.mintic.mh.moventHandler.controller;

import co.mintic.mh.moventHandler.entities.Empleado;
import co.mintic.mh.moventHandler.entities.Empresa;
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



    @GetMapping("/VerMovimientos/{id}")
    public String viewMovimientoDinero(@PathVariable Long id,@ModelAttribute("mensaje") String mensaje, Model model)  {
        List<MovimientodeDinero> listamovimientos = movimientoDineroService.findAll();
        Empleado usuario = empleadoService.findById(id).get();
        model.addAttribute("movlist",listamovimientos);
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("usuario",usuario);
        return "MovimientoDinero/verMovimiento";

    }

    @GetMapping("/AgregarMovimiento/{id}")
    public String nuevoMovimientoDinero(@PathVariable Long id,@ModelAttribute("mensaje") String mensaje,Model model){
        MovimientodeDinero movimiento = new MovimientodeDinero();
        Empleado usuario = empleadoService.findById(id).get();
        model.addAttribute("usuario",usuario);
        model.addAttribute("mov",movimiento);
        model.addAttribute("mensaje",mensaje);
        List<Empleado> listaEmpleados = empleadoService.findAll();
        model.addAttribute("emplelist",listaEmpleados);
        List<Empresa> listaEmpresa = empresaService.findAll();
        model.addAttribute("empresas",listaEmpresa);
        return "MovimientoDinero/agregarMovimiento";
    }

    @PostMapping("/GuardarMovimiento/{id}")
    public String guardarMovimientoDinero(@PathVariable Long id,MovimientodeDinero mov, RedirectAttributes redirectAttributes){
        if(movimientoDineroService.createMovimientodeDinero(mov)){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerMovimientos/"+id;
        }
        redirectAttributes.addFlashAttribute("mensaje","saveNOOK");
        return "redirect:/AgregarMovimiento/"+id;
    }

    @GetMapping("/EditarMovimiento/{id}/{id2}")
    public String editarMovimientoDinero(@PathVariable   Long id2,@ModelAttribute("mensaje") String mensaje,Model model,@PathVariable Long id) {
        MovimientodeDinero mov = movimientoDineroService.findById(id2).get();
        model.addAttribute("mov",mov);
        model.addAttribute("mensaje",mensaje);
        List<Empleado> listaempleados = empleadoService.findAll();
        model.addAttribute("emplelist",listaempleados);
        List<Empresa> listaEmpresa = empresaService.findAll();
        model.addAttribute("empresas",listaEmpresa);
        Empleado usuario = empleadoService.findById(id).get();
        model.addAttribute("usuario",usuario);
        return "MovimientoDinero/editarMovimiento";
    }


    @PostMapping("/ActualizarMovimiento/{id}")
    public String actualizarMovimientoDinero(@PathVariable Long id,@ModelAttribute("mov") String mensaje, MovimientodeDinero mov, RedirectAttributes redirectAttributes){
        if(movimientoDineroService.updateMovimientodeDinero(mov)==true){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerMovimientos/"+id;
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarMovimiento/"+id+"/"+mov.getConceptoTransaccion();
    }

    @GetMapping("/EliminarMovimiento/{id}/{id2}")
    public String eliminarMovimientoDinero(@PathVariable Long id,@PathVariable Long id2, RedirectAttributes redirectAttributes) {
        if (movimientoDineroService.deleteMovimientodeDinero(id2)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerMovimientos/"+id;
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientos/"+id;

    }



}
