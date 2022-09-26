package co.mintic.mh.moventHandler.services;

import co.mintic.mh.moventHandler.entities.Empresa;


import java.util.List;

public interface IEmpresaService {
     Empresa findById(long id);
    List<Empresa> findAll();
    Boolean createEmpresa (Empresa empresa);
    Boolean updateEmpresa ( Empresa empresa);
    Boolean deleteEmpresa(long id);
}
