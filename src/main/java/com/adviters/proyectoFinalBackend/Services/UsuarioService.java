package com.adviters.proyectoFinalBackend.Services;

import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import com.adviters.proyectoFinalBackend.models.Users.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario create (Usuario usuario) {
        return usuarioRepository.save(usuario);
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
