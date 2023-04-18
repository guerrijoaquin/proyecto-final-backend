package com.adviters.proyectoFinalBackend.Controller;

import com.adviters.proyectoFinalBackend.Model.Licencias.Licencia;
import com.adviters.proyectoFinalBackend.Model.Licencias.TipoDeEstadoDeSolicitud;
import com.adviters.proyectoFinalBackend.Model.Licencias.TipoDeLicencia;
import com.adviters.proyectoFinalBackend.Model.Users.Role;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Services.FeriadoService;
import com.adviters.proyectoFinalBackend.Services.LicenciaService;
import com.adviters.proyectoFinalBackend.Services.RoleService;
import com.adviters.proyectoFinalBackend.Services.UsuarioService;
import com.adviters.proyectoFinalBackend.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping ("api/licencia")
public class LicenciaController {

    @Autowired
    private LicenciaService licenciaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private FeriadoService feriadoService;

    @PostMapping (value = "/user/{id}")
    private ResponseEntity<Object> crearLicencia(@RequestBody Licencia licencia, @PathVariable ("id") String idUser){

        try {
            //Check if user exists.
            if (!usuarioService.exists(idUser)) throw new Exception("El usuario no existe.");
            //Check is licence has a valid format.
            if (!Validation.isValidLicence(licencia, feriadoService.getAllHolidays())) throw new Exception("El formato de la licencia es inválido.");
            licencia.setIdUser(idUser); //Set idUser on licence to be saved.

            //Set default state to pending. Best practice is in columnDefinition but not works.¡?
            TipoDeEstadoDeSolicitud tipoDeEstadoDeSolicitud = new TipoDeEstadoDeSolicitud();
            tipoDeEstadoDeSolicitud.setId(0);
            licencia.setTipoDeEstadoDeSolicitud(tipoDeEstadoDeSolicitud);


            Licencia licenciaGuardada = licenciaService.crearLicencia(licencia); //Save on DB.
            return ResponseEntity.ok(licenciaGuardada); //Send response.

        } catch (Exception e) {

            Map<String, Object> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }

    }

    @GetMapping ()
    private ResponseEntity<Object> obtenerLicencias(){
        return ResponseEntity.ok(licenciaService.getAllLicences());
    }
    //OBTENER LOS TIPOS DE LICENCIA EXISTENTES
    @GetMapping (path = "/type")
    private ResponseEntity<List<TipoDeLicencia>> getTiposDeLicencia (){
        return ResponseEntity.ok(licenciaService.getTiposDeLicencia());
    }

//    @GetMapping (path = "/user/{id}/list")
//    private ResponseEntity<List<Licencia>> getLicenciasDeUsuario(@PathVariable String id){
//        return ResponseEntity.ok(licenciaService.getLicenciasDeUsuario(id));
//    }

} 
