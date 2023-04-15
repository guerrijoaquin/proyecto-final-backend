package com.adviters.proyectoFinalBackend.Services;

import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SessionFactory sessionFactory;


    public String login(String mail, String pass) {

        Optional<Usuario> result = usuarioRepository.findOneByMail(mail);
        //Check if user exists
        if (result.isEmpty()) return "El usuario no existe";
        //Validate password
        if (!result.get().getPassword().equals(pass)) return "La contraseña es incorrecta";

        return "Login successfully";

    }

}
