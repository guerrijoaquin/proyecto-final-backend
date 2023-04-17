package com.adviters.proyectoFinalBackend.Services;

import com.adviters.proyectoFinalBackend.Model.Licencias.Licencia;
import com.adviters.proyectoFinalBackend.Model.Licencias.TipoDeLicencia;
import com.adviters.proyectoFinalBackend.Model.Users.Role;
import com.adviters.proyectoFinalBackend.Repositorys.LicenciaRepository;
import com.adviters.proyectoFinalBackend.Repositorys.RoleRepository;
import com.adviters.proyectoFinalBackend.Repositorys.TipoDeEstadoDeSolicitudRepository;
import com.adviters.proyectoFinalBackend.Repositorys.TipoDeLicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenciaService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LicenciaRepository licenciaRepository;
    @Autowired
    private TipoDeLicenciaRepository tipoDeLicenciaRepository;
    @Autowired
    private TipoDeEstadoDeSolicitudRepository tipoDeEstadoDeSolicitudRepository;

    public Licencia crearLicencia(Licencia licencia){
        return licenciaRepository.save(licencia);
    }

    public List<Licencia> getAllLicences(){
        return licenciaRepository.findAll();
    }
    public List<TipoDeLicencia> getTiposDeLicencia (){
        return tipoDeLicenciaRepository.findAll();
    }

//    public List<Licencia> getLicenciasDeUsuario (String id){
//        return licenciaRepository.getLicenciasDeUsuario(id);
//    }

}
