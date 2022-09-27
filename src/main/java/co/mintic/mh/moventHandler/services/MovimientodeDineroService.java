package co.mintic.mh.moventHandler.services;

import co.mintic.mh.moventHandler.Repository.IMovimientodeDineroRepository;

import co.mintic.mh.moventHandler.entities.Empresa;
import co.mintic.mh.moventHandler.entities.MovimientodeDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        return null;
    }


    @Override
    public Boolean createMovimientodeDinero(MovimientodeDinero movimiento) {
        try {
            MovimientodeDinero mov = movimientodeDineroRepository.save(movimiento);
        } catch (Exception err) {
            System.out.println("Hay un error" + " " + err);
        }finally {
            if (movimientodeDineroRepository.findById(movimiento.getIdTransaccion()) != null) {
                return true;
            }
            else return false;
        }

    }

    @Override
    public Boolean updateMovimientodeDinero(MovimientodeDinero movimiento){
        try {
            MovimientodeDinero mov = movimientodeDineroRepository.save(movimiento);
        } catch (Exception err) {
            System.out.println("Hay un error" + " " + err);
        } finally {
            if (movimientodeDineroRepository.findById(movimiento.getIdTransaccion()) != null) {
                return true;
            }
            else return false;
        }
    }

    @Override
    public Boolean deleteMovimientodeDinero(long id) {
        try {
            movimientodeDineroRepository.deleteById(id);
        } catch (Exception err) {
            System.out.println("Hay un error" + " " + err);
        } finally {
            if (this.movimientodeDineroRepository.findById(id).isPresent()) {
                return false;
            } else return true;
        }
    }
}
