package com.adviters.proyectoFinalBackend.Services;

import com.adviters.proyectoFinalBackend.Model.Licencias.Licencia;
import com.adviters.proyectoFinalBackend.Model.Licencias.TipoDeEstadoDeSolicitud;
import com.adviters.proyectoFinalBackend.Model.Licencias.TipoDeLicencia;
import com.adviters.proyectoFinalBackend.Model.Users.Role;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Repositorys.LicenciaRepository;
import com.adviters.proyectoFinalBackend.Repositorys.RoleRepository;
import com.adviters.proyectoFinalBackend.Repositorys.TipoDeEstadoDeSolicitudRepository;
import com.adviters.proyectoFinalBackend.Repositorys.TipoDeLicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    public Licencia updateLicenceStatus(Integer id, Integer status) {

        Licencia licecia = licenciaRepository.findById(id).get(); //Leet usuario guardado
        TipoDeEstadoDeSolicitud tipoDeEstadoDeSolicitud = new TipoDeEstadoDeSolicitud();
        tipoDeEstadoDeSolicitud.setId(status);
        licecia.setTipoDeEstadoDeSolicitud(tipoDeEstadoDeSolicitud);
        return licenciaRepository.save(licecia);

    }

    public Optional<Licencia> getLicence(Integer id){
        return licenciaRepository.findById(id);
    }

    public List<Licencia> getAllLicences(){
        return licenciaRepository.findAll();
    }
    public List<TipoDeLicencia> getTiposDeLicencia (){
        return tipoDeLicenciaRepository.findAll();
    }

    public List<Licencia> getLicencesByUser (String id){
        return licenciaRepository.getLicencesByUser(id);
    }

    public List<Licencia> getLicencesInDateRange (String inicio, String fin){
        List<Licencia> list = new ArrayList<>();
        return  list;
    }

    public List<Licencia> getLicencesByTeam(String id){
        return licenciaRepository.getLicencesByTeam(id);
    }
}
