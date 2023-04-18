package com.adviters.proyectoFinalBackend.Services;

import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Service
public class UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

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

    public boolean exists(String userId){
        Optional<Usuario> optional = this.findById(userId);
        return optional.isPresent();
    }

    public List<Map<String, Object>> getAllSupervisors() {

        List<Usuario> supervisors = usuarioRepository.getAllSupervisors();
        List<Map<String,Object>> response = new ArrayList<>();

        for (Usuario supervisor : supervisors){
            Map<String, Object> map = new HashMap<>();
            map.put("id", supervisor.getId());
            map.put("name", supervisor.getName());
            map.put("last_name", supervisor.getLastname());
            response.add(map);
        }

        return response;

    }

    public List<Map<String, Object>> getAllUsersBySupervisor(String id){

        List<Usuario> usuarios = usuarioRepository.getAllUsersBySupervisor(id);
        List<Map<String,Object>> response = new ArrayList<>();

        for (Usuario usuario : usuarios){
            Map<String, Object> map = new HashMap<>();
            map.put("id", usuario.getId());
            map.put("name", usuario.getName());
            map.put("last_name", usuario.getLastname());
            map.put("profile_picture", usuario.getProfile_picture());
            response.add(map);
        }

        return response;

    }
}
