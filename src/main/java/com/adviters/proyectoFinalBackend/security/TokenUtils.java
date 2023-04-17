package com.adviters.proyectoFinalBackend.security;

import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.security.auth.Subject;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TokenUtils {

    private final static String JWT_SCRET = "lrucnskfh57s2g6v78j4t5sa5JFTBFKFID";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L; //30 days

    @Autowired
    private static UsuarioRepository usuarioRepository;


    public static String createToken(String mail, String userId) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("mail", mail);
        extra.put("iat", Instant.now().toEpochMilli());

        return Jwts.builder() //Build JWT
                .setSubject(userId)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(JWT_SCRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = getTokenClaims(token);
            String mail = (String) claims.get("mail");

            return new UsernamePasswordAuthenticationToken(mail, null, Collections.emptyList());

        } catch (JwtException e) {
            return null;
        }
    }

    public static Claims getTokenClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(JWT_SCRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
