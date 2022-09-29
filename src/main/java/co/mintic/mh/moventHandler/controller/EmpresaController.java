package co.mintic.mh.moventHandler.controller;

import co.mintic.mh.moventHandler.entities.Empleado;
import co.mintic.mh.moventHandler.entities.Empresa;
import co.mintic.mh.moventHandler.services.IEmpleadoService;
import co.mintic.mh.moventHandler.services.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EmpresaController {
    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/VerEmpresas/{id}")
    public String viewEmpresas (@PathVariable Long id ,Model model,@ModelAttribute("mensaje") String mensaje){
        List<Empresa> listaempresas = empresaService.findAll();
        Optional<Empleado> usuario = empleadoService.findById(id);
        model.addAttribute("emprelis", listaempresas);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("usuario",usuario.get());
        return "Empleado/verEmpresas";
    }

    @GetMapping("/AgregarEmpresa/{id}")
    public String nuevaEmpresa(@PathVariable Long id,Model model,@ModelAttribute("mensaje") String mmensaje){
        Empresa empresa = new Empresa();
        Empleado usuario = empleadoService.findById(id).get();
        model.addAttribute("usuario",usuario);
        model.addAttribute("empresa",empresa);
        model.addAttribute("mensaje", mmensaje);
        return  "Empresa/agregarEmpresa";
    }

    @PostMapping("/GuardarEmpresa/{id}")
    public String guardarEmpresa(@PathVariable Long id,Empresa emp , RedirectAttributes redirectAttributes){
        if(empresaService.createEmpresa(emp)){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return  "redirect:/VerEmpresas/"+id;
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return  "redirect:/VerEmpresas/"+id;
    }

    @GetMapping("/EditarEmpresa/{id}/{id2}")
    public String editarEmpresa(@ModelAttribute("mensaje") String mensaje,Model model,@PathVariable Long id, @PathVariable Long id2 ){
        Empresa  emp= empresaService.findById(id2);
        Empleado usuario = empleadoService.findById(id).get();
        model.addAttribute("emp", emp);
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("usuario",usuario);
        return "Empresa/editarEmpresa";
    }

    @PostMapping("/ActualizarEmpresa/{id}")
    public String updateEmpresa(@PathVariable Long id,@ModelAttribute("emp") Empresa emp,RedirectAttributes redirectAttributes){
        if(empresaService.updateEmpresa(emp)) {
            redirectAttributes.addFlashAttribute("mensaje", "updateOK");
            return "redirect:/VerEmpresas/"+id;
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpresa/"+id+emp.getIdEmpresa();
    }

    @GetMapping("/EliminarEmpresa/{id}/{id2}")
    public String deleteEmpresa(@PathVariable Long id2,@PathVariable Long id, RedirectAttributes redirectAttributes){

        if( empresaService.deleteEmpresa(id2)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpresas/"+id;
        }
        else redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas/"+id;
    }
}
