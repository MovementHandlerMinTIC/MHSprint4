package co.mintic.mh.moventHandler.Repository;

import co.mintic.mh.moventHandler.entities.Empresa;
import co.mintic.mh.moventHandler.entities.MovimientodeDinero;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMovimientodeDineroRepository  extends CrudRepository <MovimientodeDinero, Long>{
    @Transactional(readOnly = true)
    List<MovimientodeDinero> findByempresa(Empresa idEmpresa);
}
