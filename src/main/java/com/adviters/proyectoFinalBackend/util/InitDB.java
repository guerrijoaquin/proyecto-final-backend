package com.adviters.proyectoFinalBackend.util;

import com.adviters.proyectoFinalBackend.Model.Licencias.TipoDeEstadoDeSolicitud;
import com.adviters.proyectoFinalBackend.Model.Licencias.TipoDeLicencia;
import com.adviters.proyectoFinalBackend.Model.Users.Role;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Repositorys.RoleRepository;
import com.adviters.proyectoFinalBackend.Repositorys.TipoDeEstadoDeSolicitudRepository;
import com.adviters.proyectoFinalBackend.Repositorys.TipoDeLicenciaRepository;
import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;

public class InitDB {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TipoDeEstadoDeSolicitudRepository tipoDeEstadoDeSolicitudRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TipoDeLicenciaRepository tipoDeLicenciaRepository;


    public InitDB(){

    }

    public void initialize(){
        setRoles();
        setTiposDeEstadoDeSolicitud();
        setTiposDeLicencia();
    }
    private void setRoles(){
        Role usuario = new Role();
        usuario.setId("0");
        usuario.setRole_name("Usuario");
        roleRepository.save(usuario);

        Role supervisor = new Role();
        supervisor.setId("1");
        supervisor.setRole_name("Supervisor");
        roleRepository.save(supervisor);
    }

    private void setTiposDeLicencia(){
        TipoDeLicencia salud = new TipoDeLicencia();
        salud.setId(0);
        salud.setDescripcion("Salud");
        tipoDeLicenciaRepository.save(salud);

        TipoDeLicencia vacaciones = new TipoDeLicencia();
        vacaciones.setId(1);
        vacaciones.setDescripcion("Vacaciones");
        tipoDeLicenciaRepository.save(salud);

        TipoDeLicencia estudio = new TipoDeLicencia();
        estudio.setId(2);
        estudio.setDescripcion("Estudio");
        tipoDeLicenciaRepository.save(salud);
    }

    private void setTiposDeEstadoDeSolicitud(){
        TipoDeEstadoDeSolicitud pendiente = new TipoDeEstadoDeSolicitud();
        pendiente.setId(0);
        pendiente.setDescripcion("Pendiente");
        tipoDeEstadoDeSolicitudRepository.save(pendiente);

        TipoDeEstadoDeSolicitud aceptada = new TipoDeEstadoDeSolicitud();
        pendiente.setId(1);
        pendiente.setDescripcion("Aceptada");
        tipoDeEstadoDeSolicitudRepository.save(pendiente);

        TipoDeEstadoDeSolicitud rechazada = new TipoDeEstadoDeSolicitud();
        pendiente.setId(2);
        pendiente.setDescripcion("Rechazada");
        tipoDeEstadoDeSolicitudRepository.save(pendiente);
    }
}
