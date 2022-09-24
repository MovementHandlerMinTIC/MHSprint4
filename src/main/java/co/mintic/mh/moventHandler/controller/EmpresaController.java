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

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class EmpresaController {
    @Autowired
    private IEmpresaService empresaService;
    @Autowired
    private IEmpleadoService empleadoService;
    @Autowired
    private IMovimientodeDineroService movimientodeDineroService;

    private final Logger LOG = Logger.getLogger(""+EmpleadoController.class);

    @GetMapping("/empresa/findall")
    public String getListEmpresa(Model model){
        LOG.log(Level.INFO,"getListEmpresa");
        List<Empresa> empresas = empresaService.findAll();
        model.addAttribute("empresas", empresas);
        return "empresas/get";
    }

    @GetMapping("/empresa/crear")
    public String createEmpresa(Model model){
        LOG.log(Level.INFO,"createEmpresa");
        Empresa empresa = new Empresa();
        model.addAttribute("empresa",empresa);
        return  "empresas/update";
    }

    @PostMapping("/guardar")
    public String saveEmpresa(Empresa empresa){
        LOG.log(Level.INFO,"saveEmpresa");
        empresa = empresaService.createEmpresa(empresa);
        return "redirect:empresa/findall";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateEmpresa(@PathVariable("id") long id, Model modelo){
        LOG.log(Level.INFO,"updateEmpresa");
        System.out.println(id);
        Empresa empresa = empresaService.findById(id);
        System.out.println(empresa.toString());
        modelo.addAttribute("empresa",empresa);
        return "empresas/update";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmpresa(@PathVariable("id") long id, Model modelo){
        LOG.log(Level.INFO,"deleteEmpresa");
        empresaService.deleteEmpresa(id);
        return "redirect:/empresa/findall";
    }
}
