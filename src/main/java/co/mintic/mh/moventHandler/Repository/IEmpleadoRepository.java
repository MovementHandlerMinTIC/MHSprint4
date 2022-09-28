package co.mintic.mh.moventHandler.Repository;


import co.mintic.mh.moventHandler.entities.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoRepository extends CrudRepository<Empleado, Long> {

    Empleado findByCorreoEmpleado(String correo);
}
