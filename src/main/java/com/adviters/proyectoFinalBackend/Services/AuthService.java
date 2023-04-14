package com.adviters.proyectoFinalBackend.Services;

import com.adviters.proyectoFinalBackend.Models.Users.Usuario;
import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SessionFactory sessionFactory;


    public String login(String mail, String pass){

        Session session = sessionFactory.getCurrentSession();
        Query<Usuario> query = session.createQuery("from Usuario u where u.mail=:mail", Usuario.class);
        query.setParameter("mail", mail);
        Usuario usuario = query.uniqueResult();

        if (usuario == null) return "El usuario no existe";

        if (!usuario.getPassword().equals(pass)) return "La contraseña es incorrecta";

        return "Login successfully";

    }

}
