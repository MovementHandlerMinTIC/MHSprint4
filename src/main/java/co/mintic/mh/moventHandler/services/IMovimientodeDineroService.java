package co.mintic.mh.moventHandler.services;

import co.mintic.mh.moventHandler.entities.MovimientodeDinero;
import co.mintic.mh.moventHandler.entities.Empresa;


import java.util.List;
import java.util.Optional;

public interface IMovimientodeDineroService {

    Optional<MovimientodeDinero> findById(long id);
    List<MovimientodeDinero> findAll();
    List<MovimientodeDinero> findByempresa(Empresa idEmpresa);
    MovimientodeDinero createMovimientodeDinero(MovimientodeDinero movimientodeDinero);
    MovimientodeDinero updateMovimientodeDinero(long id, MovimientodeDinero movimientodeDinero);
    void deleteMovimientodeDinero(long id);
}
