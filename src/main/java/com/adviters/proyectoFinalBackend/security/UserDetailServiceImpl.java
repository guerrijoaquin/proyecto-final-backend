package com.adviters.proyectoFinalBackend.security;

import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findOneByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));

        return new UserDetailsImpl(usuario);
    }
}
