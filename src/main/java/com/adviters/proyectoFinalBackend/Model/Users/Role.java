package com.adviters.proyectoFinalBackend.Model.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashMap;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@AutoConfiguration
public class Role implements GrantedAuthority {

    @Id @GeneratedValue
    private Integer id;

    @Column (nullable = false, unique = true)
    private String role_name;


    //AUDIT DATA
    @CreationTimestamp
    @JsonIgnore
    @Column (updatable = false, nullable = false)
    private Timestamp Created_at;
    @Column (updatable = false, nullable = false)
    @JsonIgnore
    private String Created_by;
    @Nullable
    @JsonIgnore
    @UpdateTimestamp
    private Timestamp Updated_at;
    @Nullable
    @JsonIgnore
    private String Updated_by;

    @PrePersist
    public void prePersist(){

        //Configure audit data
//        HashMap<String, Object> authDetails = (HashMap<String, Object>) SecurityContextHolder.getContext().getAuthentication().getDetails();
//        String creatorId =  (String) authDetails.get("userId");
        this.setCreated_by("ADMIN");
    }
    @PreUpdate
    public void preUpdate(){

        //Configure audit data
//        HashMap<String, Object> authDetails = (HashMap<String, Object>) SecurityContextHolder.getContext().getAuthentication().getDetails();
//        String updaterId =  (String) authDetails.get("userId");
        this.setUpdated_by("ADMIN");
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.role_name;
    }
}
