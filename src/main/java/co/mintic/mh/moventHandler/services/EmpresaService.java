package co.mintic.mh.moventHandler.services;



import co.mintic.mh.moventHandler.Repository.IEmpresaRepository;
import co.mintic.mh.moventHandler.entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements IEmpresaService{

    @Autowired
    private IEmpresaRepository empresaRepository;


    @Override
    public Empresa findById(long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.get();
    }

    @Override
    public List<Empresa> findAll() {
        List<Empresa> empresas = (List<Empresa>) empresaRepository.findAll();
        return empresas;
    }

    @Override
    public Boolean createEmpresa(Empresa empresa) {
        Empresa emp = empresaRepository.save(empresa);
        if(empresaRepository.findById(emp.getIdEmpresa())!=null){
        empresaRepository.save(emp);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateEmpresa( Empresa empresa) {
        Empresa emp = empresaRepository.save(empresa);
        if (empresaRepository.findById(emp.getIdEmpresa()) != null) {
            empresaRepository.save(emp);
            return true;
        }
        return false;
    }
    @Override
    public Boolean deleteEmpresa(long id) {
        empresaRepository.deleteById(id);
        if(this.empresaRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }


}
