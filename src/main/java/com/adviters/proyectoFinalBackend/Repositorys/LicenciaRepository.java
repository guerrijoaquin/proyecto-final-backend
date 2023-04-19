package com.adviters.proyectoFinalBackend.Repositorys;

import com.adviters.proyectoFinalBackend.Model.Licencias.Licencia;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LicenciaRepository extends JpaRepository<Licencia, Integer> {

    @Query ("SELECT e FROM Licencia e WHERE e.idUser=(:id)")
    List<Licencia> getLicencesByUser(@Param("id") String id);

    @Query ("SELECT e FROM Licencia e WHERE e.supervisor=(:id)")
    List<Licencia> getLicencesByTeam(@Param("id") String id);

}
