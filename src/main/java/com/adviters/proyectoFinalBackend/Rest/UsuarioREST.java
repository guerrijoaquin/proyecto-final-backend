package com.adviters.proyectoFinalBackend.Rest;

import com.adviters.proyectoFinalBackend.Services.UsuarioService;
import com.adviters.proyectoFinalBackend.models.Users.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/v1/usuario")
public class UsuarioREST {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private ResponseEntity<Usuario> guardar (@RequestBody Usuario usuario){
        Usuario temporal = usuarioService.create(usuario);

        try {
            return ResponseEntity.created(new URI("/v1/usuario"+temporal.getId())).body(temporal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping
    private ResponseEntity<List<Usuario>> listarTodosLosUsuarios (){
        return ResponseEntity.ok(usuarioService.getAllUsers());
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarUsuario (@RequestBody Usuario usuario){
         usuarioService.delete(usuario);
         return ResponseEntity.ok().build();
    }


    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Usuario>> listarUsuariosPorID (@PathVariable ("id") String id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }
}
