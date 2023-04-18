package com.adviters.proyectoFinalBackend.Repositorys;

import com.adviters.proyectoFinalBackend.Model.Calendar.Feriado;
import com.adviters.proyectoFinalBackend.Model.Users.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeriadoRepository extends JpaRepository<Feriado, Integer> {


}
