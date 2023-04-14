package com.adviters.proyectoFinalBackend.Rest;

import com.adviters.proyectoFinalBackend.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthREST {

    @Autowired
    private AuthService authService;

    @PostMapping
    private ResponseEntity<Object> login(Map<String, String> data){

        try {

            String mail = data.get("mail");
            String pass = data.get("password");

            String response = authService.login(mail, pass);

            return ResponseEntity.status(200).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
