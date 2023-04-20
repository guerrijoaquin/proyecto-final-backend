package com.adviters.proyectoFinalBackend.security;

import com.adviters.proyectoFinalBackend.Model.Users.Role;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Repositorys.RoleRepository;
import com.adviters.proyectoFinalBackend.Repositorys.UsuarioRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.*;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String bearerToken = request.getHeader("Authorization");


        if (bearerToken != null && bearerToken.startsWith("Bearer ")){

            String token = bearerToken.substring(7);

            Claims claims = TokenUtils.getTokenClaims(token);
            String userId = claims.getSubject();

            Optional<Usuario> usuario = usuarioRepository.findById(userId);
            if (usuario.isPresent()) {

                Instant jwt_iat = Instant.ofEpochMilli((long) claims.get("iat"));
                Instant lastPasswordUpdate = usuario.get().getPasswordLastUpdate();

                //CHECK IF USER PASSWORD WAS NOT UPDATED AFTER JWT GENERATION.
                if (lastPasswordUpdate.isBefore(jwt_iat)) {

                    HashMap<String, Object> authDetails = new HashMap<>();
                    authDetails.put("userId", userId);

                    Integer roleId = usuario.get().getRole_id();
                    Optional<Role> role = roleRepository.findById(roleId);
                    if (role.isPresent()) {

                        List<Role> roles = new ArrayList<>();
                        roles.add(role.get());

                        UsernamePasswordAuthenticationToken usernamePAT = TokenUtils.getAuthentication(token, roles);
                        usernamePAT.setDetails(authDetails);
                        SecurityContextHolder.getContext().setAuthentication(usernamePAT);

                    }


                }
            }
        }

        filterChain.doFilter(request, response);

    }
}
