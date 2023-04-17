package com.adviters.proyectoFinalBackend.Repositorys;

import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findOneByMail(String mail);

//    @Query("FROM usuario WHERE supervisor=:supervisorId")
//    List<Usuario> searchBySupervisor(String supervisorId);


}
