package co.mintic.mh.moventHandler.controller;

import co.mintic.mh.moventHandler.entities.Empleado;
import co.mintic.mh.moventHandler.entities.Empresa;
import co.mintic.mh.moventHandler.services.IEmpleadoService;
import co.mintic.mh.moventHandler.services.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
public class EmpleadoController {

    @Autowired
    public IEmpleadoService empleadoService;

    @Autowired
    public IEmpresaService empresaService;

    @GetMapping("/VerEmpleados")
    public String viewempleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empleado> Listaempleados = empleadoService.findAll();
        model.addAttribute("emplelist", Listaempleados);
        model.addAttribute("mensaje", mensaje);
        return "empleados/get";

    }

    @GetMapping("/AgregarEmpleado")
    public String nuevoEmpleado(Model model, @ModelAttribute("mensaje") String mmensaje) {
        Empleado empl = new Empleado();
        model.addAttribute("empl", empl);
        model.addAttribute("mensaje", mmensaje);
        List<Empresa> listaempresas = empresaService.findAll();
        model.addAttribute("emprelist",listaempresas);
        return "empleados/update"; //Llamar HTML

    }

}
