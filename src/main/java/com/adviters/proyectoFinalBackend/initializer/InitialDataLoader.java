package com.adviters.proyectoFinalBackend.initializer;

import com.adviters.proyectoFinalBackend.Model.Licencias.TipoDeEstadoDeSolicitud;
import com.adviters.proyectoFinalBackend.Model.Licencias.TipoDeLicencia;
import com.adviters.proyectoFinalBackend.Model.Users.Role;
import com.adviters.proyectoFinalBackend.Repositorys.RoleRepository;
import com.adviters.proyectoFinalBackend.Repositorys.TipoDeEstadoDeSolicitudRepository;
import com.adviters.proyectoFinalBackend.Repositorys.TipoDeLicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitialDataLoader {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TipoDeLicenciaRepository tipoDeLicenciaRepository;

    @Autowired
    private TipoDeEstadoDeSolicitudRepository tipoDeEstadoDeSolicitudRepository;

    @PostConstruct
    public void setInitData(){

        setRoles();
        setLicenceTypes();
        setStatusTypes();

    }

    private void setRoles(){

        if (roleRepository.count() == 0) {

            Role role1 = new Role();
            role1.setId(0);
            role1.setRole_name("Supervisor");

            Role role2 = new Role();
            role2.setId(1);
            role2.setRole_name("Usuario");

            List<Role> roles = Arrays.asList(role1, role2);
            roleRepository.saveAll(roles);

        }

    }

    private void setLicenceTypes(){

        if (tipoDeLicenciaRepository.count() == 0) {

            TipoDeLicencia tipo1 = new TipoDeLicencia();
            tipo1.setId(0);
            tipo1.setDescripcion("Salud");
            tipo1.setRequiredDocumentation(false);

            TipoDeLicencia tipo2 = new TipoDeLicencia();
            tipo2.setId(1);
            tipo2.setDescripcion("Vacaciones");
            tipo2.setRequiredDocumentation(false);

            TipoDeLicencia tipo3 = new TipoDeLicencia();
            tipo3.setId(2);
            tipo3.setDescripcion("Estudio");
            tipo3.setRequiredDocumentation(false);

            List<TipoDeLicencia> tipos = Arrays.asList(tipo1, tipo2, tipo3);
            tipoDeLicenciaRepository.saveAll(tipos);

        }

    }

    private void setStatusTypes(){

        if (tipoDeEstadoDeSolicitudRepository.count() == 0) {

            TipoDeEstadoDeSolicitud tipo1 = new TipoDeEstadoDeSolicitud();
            tipo1.setId(0);
            tipo1.setDescripcion("Pendiente");

            TipoDeEstadoDeSolicitud tipo2 = new TipoDeEstadoDeSolicitud();
            tipo2.setId(1);
            tipo2.setDescripcion("Aceptada");

            TipoDeEstadoDeSolicitud tipo3 = new TipoDeEstadoDeSolicitud();
            tipo3.setId(2);
            tipo3.setDescripcion("Rechazada");

            List<TipoDeEstadoDeSolicitud> tipos = Arrays.asList(tipo1, tipo2, tipo3);
            tipoDeEstadoDeSolicitudRepository.saveAll(tipos);

        }

    }
}
