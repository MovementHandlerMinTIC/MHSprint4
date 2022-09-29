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

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;


@Controller
public class EmpleadoController {


    @Autowired
    public EmpleadoService empleadoService;

    @Autowired
    public IEmpresaService empresaService;

    @GetMapping("/VerEmpleados/{id}")
    public String viewempleado(@PathVariable Long id,Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empleado> Listaempleados = empleadoService.findAll();
        Optional<Empleado> usuario = empleadoService.findById(id);
        model.addAttribute("emplelist", Listaempleados);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("usuario",usuario.get());
        return "Empleado/verEmpleados";

    }

    @GetMapping("/AgregarEmpleado/{id}")
    public String nuevoEmpleado(@PathVariable Long id,Model model, @ModelAttribute("mensaje") String mmensaje) {

        Empleado empl = new Empleado();
        model.addAttribute("empl", empl);
        model.addAttribute("mensaje", mmensaje);
        model.addAttribute("usuario",empleadoService.findById(id).get());
        List<Empresa> listaempresas = empresaService.findAll();
        model.addAttribute("emprelist", listaempresas);
        return "Empleado/agregarEmpleado"; //Llamar HTML

    }

    @PostMapping("/GuardarEmpleado/{id}")
    public String guardarEmpleado(@PathVariable Long id,Empleado emp, RedirectAttributes redirectAttributes) {
        //Empleado usuario = empleadoService.findById(id).get();
        System.out.println("datos"+emp);
        if (empleadoService.createEmpleado(emp)){
            redirectAttributes.addFlashAttribute("mensaje", "saveOK");
            return "redirect:/VerEmpleados/"+id;
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/AgregarEmpleado/"+id;
    }
    @GetMapping("/EditarEmpleado/{id}/{id2}")
    public String editarEmpleado(Model model, @PathVariable Long id,@PathVariable Long id2,@ModelAttribute("mensaje") String mensaje)  {
        Empleado empl=empleadoService.findById(id2).get();
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas= empresaService.findAll();
        model.addAttribute("emprelist",listaEmpresas);
        model.addAttribute("usuario",empleadoService.findById(id).get());
        empl.toString();
        return "Empleado/editarEmpleado";
    }

    @PostMapping("/ActualizarEmpleado/{id}")
    public String updateEmpleado(@PathVariable Long id,@ModelAttribute("empl") Empleado empl, RedirectAttributes redirectAttributes)  {
        Empleado usuario = empleadoService.findById(id).get();

        if(empleadoService.updateEmpleado(empl)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpleados/"+usuario.getIdEmpleado();
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpleado/"+usuario.getIdEmpleado()+"/"+empl.getIdEmpleado();

    }

    @GetMapping("/EliminarEmpleado/{id}/{id2}")
    public String eliminarEmpleado(@PathVariable Long id,@PathVariable Long id2, RedirectAttributes redirectAttributes)  {
        if (empleadoService.deleteEmpleado(id2)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpleados/"+id;
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleados/"+id;
    }


}