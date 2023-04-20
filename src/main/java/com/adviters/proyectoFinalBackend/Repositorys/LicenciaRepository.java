package com.adviters.proyectoFinalBackend.Repositorys;

import com.adviters.proyectoFinalBackend.Model.Licencias.Licencia;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LicenciaRepository extends JpaRepository<Licencia, Integer> {

    @Query ("SELECT e FROM Licencia e JOIN FETCH e.usuario userId WHERE userId.id=(:id)")
    List<Licencia> getLicencesByUser(@Param("id") String id);

    void deleteLicenciaByusuario(
      @Param("id") Usuario usuario
    );
    @Query ("SELECT e FROM Licencia e WHERE e.supervisor=(:id)")
    List<Licencia> getLicencesByTeam(@Param("id") String id);

}
