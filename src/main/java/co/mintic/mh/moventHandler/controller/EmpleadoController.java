package co.mintic.mh.moventHandler.controller;

import co.mintic.mh.moventHandler.entities.Empleado;
import co.mintic.mh.moventHandler.entities.Empresa;

import co.mintic.mh.moventHandler.services.EmpleadoService;
import co.mintic.mh.moventHandler.services.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class EmpleadoController {


    @Autowired
    public EmpleadoService empleadoService;

    @Autowired
    public IEmpresaService empresaService;

    @GetMapping("/VerEmpleados")
    public String viewempleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empleado> Listaempleados = empleadoService.findAll();
        model.addAttribute("emplelist", Listaempleados);
        model.addAttribute("mensaje", mensaje);
        return "Empleado/verEmpleados";

    }

    @GetMapping("/AgregarEmpleado")
    public String nuevoEmpleado(Model model, @ModelAttribute("mensaje") String mmensaje) {
        Empleado empl = new Empleado();
        model.addAttribute("empl", empl);
        model.addAttribute("mensaje", mmensaje);
        List<Empresa> listaempresas = empresaService.findAll();
        model.addAttribute("emprelist", listaempresas);
        return "Empleado/agregarEmpleado"; //Llamar HTML

    }

    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Empleado emp, RedirectAttributes redirectAttributes) {
        if (empleadoService.createEmpleado(emp)){
            redirectAttributes.addFlashAttribute("mensaje", "saveOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/AgregarEmpleado";
    }
    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje)  {
        Empleado empl=empleadoService.findById(id).get();
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas= empresaService.findAll();
        model.addAttribute("emprelist",listaEmpresas);
        return "Empleado/editarEmpleado";
    }

    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("empl") Empleado empl, RedirectAttributes redirectAttributes)  {
        if(empleadoService.updateEmpleado(empl)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpleado/"+empl.getIdEmpleado();

    }

    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id, RedirectAttributes redirectAttributes)  {
        if (empleadoService.deleteEmpleado(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleados";
    }


}