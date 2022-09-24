package co.mintic.mh.moventHandler.services;

import co.mintic.mh.moventHandler.Repository.IMovimientodeDineroRepository;

import co.mintic.mh.moventHandler.entities.Empresa;
import co.mintic.mh.moventHandler.entities.MovimientodeDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientodeDineroService implements IMovimientodeDineroService{

    @Autowired
    IMovimientodeDineroRepository movimientodeDineroRepository;

    @Override
    public Optional<MovimientodeDinero> findById(long id) {
        Optional<MovimientodeDinero> movimientodeDinero = movimientodeDineroRepository.findById(id);
        return movimientodeDinero;
    }



    @Override
    public List<MovimientodeDinero> findAll() {
        List<MovimientodeDinero> movimientosdeDinero = (List<MovimientodeDinero>) movimientodeDineroRepository.findAll();
        return movimientosdeDinero;
    }

    @Override
    public List<MovimientodeDinero> findByempresa(Empresa idEmpresa) {
        List<MovimientodeDinero> movimientodeDinero = movimientodeDineroRepository.findByempresa(idEmpresa);
        return movimientodeDinero;
    }

    @Override
    public MovimientodeDinero createMovimientodeDinero(MovimientodeDinero movimientodeDinero) {
        MovimientodeDinero newMovimientodeDinero = movimientodeDineroRepository.save(movimientodeDinero);
        return newMovimientodeDinero;
    }

    @Override
    public MovimientodeDinero updateMovimientodeDinero(long id, MovimientodeDinero movimientodeDinero) {
        MovimientodeDinero putMovimientodeDinero = movimientodeDineroRepository.save(movimientodeDinero);
        return putMovimientodeDinero;
    }

    @Override
    public void deleteMovimientodeDinero(long id) {
        movimientodeDineroRepository.deleteById(id);
    }
}
