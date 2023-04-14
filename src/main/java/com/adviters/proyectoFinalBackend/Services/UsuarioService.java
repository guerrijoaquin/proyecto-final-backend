package com.adviters.proyectoFinalBackend.Services;

import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import com.adviters.proyectoFinalBackend.Models.Users.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Create user
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Update user fields
    public Usuario update(Usuario usuario) {

        Usuario usuarioActual = usuarioRepository.findById(usuario.getId()).get(); //Leet usuario guardado
        ServiceUtils.copyNonNullProperties(usuario, usuarioActual); // Comparar con los datos recibidos y actualizar solo los campos presentes.
        return usuarioRepository.save(usuarioActual);

    }

    public List<Usuario> getAllUsers (){
        return usuarioRepository.findAll();
    }

    public void delete (Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public Optional<Usuario> findById (String id) {

        return usuarioRepository.findById(id);
    }

}
