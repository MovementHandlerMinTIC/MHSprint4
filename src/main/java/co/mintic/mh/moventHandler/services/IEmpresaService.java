package co.mintic.mh.moventHandler.services;

import co.mintic.mh.moventHandler.entities.Empresa;


import java.util.List;

public interface IEmpresaService {
    public Empresa findById(long id);
    public List<Empresa> findAll();
    public Empresa createEmpresa (Empresa empresa);
    public Empresa updateEmpresa (long id, Empresa empresa);
    public void deleteEmpresa(long id);
}
