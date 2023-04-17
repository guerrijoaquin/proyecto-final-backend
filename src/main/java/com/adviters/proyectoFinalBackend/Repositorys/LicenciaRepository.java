package com.adviters.proyectoFinalBackend.Repositorys;

import com.adviters.proyectoFinalBackend.Model.Licencias.Licencia;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LicenciaRepository extends JpaRepository<Licencia, String> {


//    @Query("SELECT all FROM licencia WHERE idUser=:id ")
//    public List<Licencia> getLicenciasDeUsuario(@Param("id") String id);

}
