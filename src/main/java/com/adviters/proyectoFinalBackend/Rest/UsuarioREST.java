package com.adviters.proyectoFinalBackend.Rest;

import com.adviters.proyectoFinalBackend.Services.UsuarioService;
import com.adviters.proyectoFinalBackend.Models.Users.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping ("/v1/usuario")
public class UsuarioREST {

    @Autowired
    private UsuarioService usuarioService;

    //CREATE NEW USER
    @PostMapping
    private ResponseEntity<Object> create (@RequestBody Usuario usuario){

        try {

            if (usuario.getId() != null) throw new Exception();

            Usuario temporal = usuarioService.createOrUpdate(usuario);

            Map<String, Object> response = new HashMap<>();
            response.put("id", temporal.getId());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //UPDATE USER DATA
    @PutMapping ()
    private ResponseEntity<Object> update (@RequestBody Usuario usuario){

        try {
            Usuario temporal = usuarioService.createOrUpdate(usuario);

            Map<String, Object> response = new HashMap<>();
            response.put("id", temporal.getId());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //GET AN USER BY ID
    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Usuario>> getUserById (@PathVariable ("id") String id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    //DELETE AN USER
    @DeleteMapping
    private ResponseEntity<Void> deleteUser (@RequestBody Usuario usuario){
         usuarioService.delete(usuario);
         return ResponseEntity.ok().build();
    }

    //GET ALL USERS
    @GetMapping
    private ResponseEntity<List<Usuario>> getAllUsers (){
        return ResponseEntity.ok(usuarioService.getAllUsers());
    }

}
