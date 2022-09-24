package co.mintic.mh.moventHandler.services;

import co.mintic.mh.moventHandler.Repository.IEmpleadoRepository;
import co.mintic.mh.moventHandler.entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService{

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
    public Empleado createEmpleado(Empleado empleado) {
        Empleado newEmpleado = empleadoRepository.save(empleado);
        return newEmpleado;
    }

    @Override
    public Empleado updateEmpleado(long id, Empleado empleado) {
        Empleado putEmpleado = empleadoRepository.save(empleado);
        return putEmpleado;
    }

    @Override
    public void deleteEmpleado(long id) {
        empleadoRepository.deleteById(id);
    }
}
