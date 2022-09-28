package co.mintic.mh.moventHandler.services;



import co.mintic.mh.moventHandler.entities.Empleado;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IEmpleadoService {
    Optional<Empleado> findById(long id);
    List<Empleado> findAll();
     Boolean createEmpleado(Empleado empleado);
      Boolean updateEmpleado ( Empleado empleado);
     Boolean deleteEmpleado(long id);
     Empleado findByCorreo(String correo);
     Empleado getOrCreateEmpleado(Map<String,Object> userData);




}
