package com.adviters.proyectoFinalBackend.Repositorys;

import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findOneByMail(String mail);

    @Query("SELECT e FROM Usuario e WHERE e.Role_id=0")
    List<Usuario> getAllSupervisors();

    @Query ("SELECT e FROM Usuario e WHERE e.supervisor=(:id)")
    List<Usuario> getAllUsersBySupervisor(@Param("id") String id);

}
