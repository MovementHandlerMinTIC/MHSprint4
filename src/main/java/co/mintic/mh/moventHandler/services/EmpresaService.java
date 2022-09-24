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
    public Empresa createEmpresa(Empresa empresa) {
        Empresa newEmpresa = empresaRepository.save(empresa);
        return newEmpresa;
    }

    @Override
    public Empresa updateEmpresa(long id, Empresa empresa) {
        Empresa putEmpresa = empresaRepository.save(empresa);
        return putEmpresa;
    }

    @Override
    public void deleteEmpresa(long id) {
        empresaRepository.deleteById(id);
    }

}
