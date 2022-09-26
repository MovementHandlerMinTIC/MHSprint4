package co.mintic.mh.moventHandler.controller;

import co.mintic.mh.moventHandler.entities.Empleado;
import co.mintic.mh.moventHandler.entities.Empresa;
import co.mintic.mh.moventHandler.services.IEmpleadoService;
import co.mintic.mh.moventHandler.services.IEmpresaService;
import co.mintic.mh.moventHandler.services.IMovimientodeDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class EmpresaController {
    @Autowired
    private IEmpresaService empresaService;

    @GetMapping("/VerEmpresas")
    public String viewEmpresas ( Model model,@ModelAttribute("mensaje") String mensaje){
        List<Empresa> listaempresas = empresaService.findAll();
        model.addAttribute("emprelis", listaempresas);
        model.addAttribute("mensaje", mensaje);
        return "Empresa/verEmpresas";
    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model,@ModelAttribute("mensaje") String mmensaje){
        Empresa empresa = new Empresa();
        model.addAttribute("empresa",empresa);
        model.addAttribute("mensaje", mmensaje);
        return  "Empresa/agregarEmpresa";
    }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp , RedirectAttributes redirectAttributes){
        if(empresaService.createEmpresa(emp)){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return  "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return  "redirect:/VerEmpresas";
    }

    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(@ModelAttribute("mensaje") String mensaje,Model model,@PathVariable Long id ){
        Empresa  emp= empresaService.findById(id);
        model.addAttribute("emp", emp);
        model.addAttribute("mensaje",mensaje);
        return "Empresa/editarEmpresa";
    }

    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(@ModelAttribute("emp") Empresa emp,RedirectAttributes redirectAttributes){
        if(empresaService.updateEmpresa(emp)) {
            redirectAttributes.addFlashAttribute("mensaje", "updateOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpresa/"+emp.getIdEmpresa();
    }

    @GetMapping("/EliminarEmpresa/{id}")
    public String deleteEmpresa(@PathVariable Long id, RedirectAttributes redirectAttributes){

        if( empresaService.deleteEmpresa(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpresas";
        }
        else redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas";
    }
}
