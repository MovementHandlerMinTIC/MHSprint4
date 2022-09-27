package co.mintic.mh.moventHandler.services;



import co.mintic.mh.moventHandler.Repository.IEmpresaRepository;
import co.mintic.mh.moventHandler.entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        try{
            Empresa emp = empresaRepository.save(empresa);
        } catch (Exception err){
            System.out.println("Hay un error"+" "+err);
        } finally {
            if(empresaRepository.findById(empresa.getIdEmpresa())!=null){
                empresaRepository.save(empresa);
                return true;
            }
            else return false;
        }


    }

    @Override
    public Boolean updateEmpresa( Empresa empresa) {

        try{
            Empresa emp = empresaRepository.save(empresa);
        } catch (Exception err){
            System.out.println("Hay un error"+" "+err);
        } finally {
            if (empresaRepository.findById(empresa.getIdEmpresa()) != null) {
                empresaRepository.save(empresa);
                return true;
            }
            return false;
        }


    }
    @Override
    public Boolean deleteEmpresa(long id) {

        try{
            empresaRepository.deleteById(id);
        } catch (Exception err){
            System.out.println("Hay un error"+" "+err);
        }

        finally {
            if(this.empresaRepository.findById(id).isPresent()){
                return false;
            }
           else return true;
        }


    }


}
