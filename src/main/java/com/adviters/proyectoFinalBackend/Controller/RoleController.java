package com.adviters.proyectoFinalBackend.Controller;

import com.adviters.proyectoFinalBackend.Model.Users.Role;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Services.RoleService;
import com.adviters.proyectoFinalBackend.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping ("api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    private ResponseEntity<List<Role>> getAllUsers (){
        return ResponseEntity.ok(roleService.getAllRoles());
    }

} 
