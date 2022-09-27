package co.mintic.mh.moventHandler.services;

import co.mintic.mh.moventHandler.entities.Empresa;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface IEmpresaService {
     Empresa findById(long id);
     @Query("Select e from Empresas e order by id_empresa")
    List<Empresa> findAll();
    Boolean createEmpresa (Empresa empresa);
    Boolean updateEmpresa ( Empresa empresa);
    Boolean deleteEmpresa(long id);
}
