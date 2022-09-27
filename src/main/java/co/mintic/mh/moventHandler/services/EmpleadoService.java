package co.mintic.mh.moventHandler.services;

import co.mintic.mh.moventHandler.Repository.IEmpleadoRepository;
import co.mintic.mh.moventHandler.entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    public Optional<Empleado> findById(long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado;
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> empleados = (List<Empleado>) empleadoRepository.findAll();
        return empleados;
    }

    @Override
    public Boolean createEmpleado(Empleado empl) {
        try {
            Empleado emp = empleadoRepository.save(empl);
        } catch (Exception err) {
            System.out.println("Hay un error" + " " + err);
        } finally {
            if (empleadoRepository.findById(empl.getIdEmpleado()) != null) {
                empleadoRepository.save(empl);
                return true;
            }
            return false;
        }


    }

    @Override
    public Boolean updateEmpleado(Empleado empl) {
        try {
            Empleado emp =empleadoRepository.save(empl);
        }  catch (Exception err) {
        System.out.println("Hay un error" + " " + err);
        } finally {
            if(empleadoRepository.findById(empl.getIdEmpleado())!=null){
                empleadoRepository.save(empl);
                return true;
            }
            else return false;
        }


    }

    @Override
    public Boolean deleteEmpleado(long id) {

        try {
            empleadoRepository.deleteById(id);
        } catch (Exception err) {
            System.out.println("Hay un error" + " " + err);
        } finally {
            if (this.empleadoRepository.findById(id).isPresent()) {
                return false;
            } else return true;
        }
    }
}
