package com.adviters.proyectoFinalBackend.Services;

import com.adviters.proyectoFinalBackend.Model.Users.Role;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Repositorys.RoleRepository;
import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles (){
        return roleRepository.findAll();
    }

}
