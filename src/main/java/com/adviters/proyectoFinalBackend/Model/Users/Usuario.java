package com.adviters.proyectoFinalBackend.Model.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@AutoConfiguration
public class Usuario {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private String lastname;
    @Column (nullable = false)
    private String password;
    private String oldPassword;
    @CreationTimestamp
    private Instant passwordLastUpdate;
    @Column (unique = true, nullable = false)
    private String mail;
    @Column (nullable = false)
    private Integer phone;
    @Nullable
    private String street;
    @Nullable
    private Integer Street_number;
    @Nullable
    @Column (nullable = false)
    private String tower;
    @Nullable
    private String town;
    @Nullable
    private String state;
    @Nullable
    private String country;
    @Lob
    @Nullable
    private Blob Profile_picture;
    @Column (nullable = false)
    private Integer Role_id;
    @Column (nullable = false)
    private LocalDate Birth_date;
    @Column (nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date Start_working_date;
    @Column (nullable = false)
    private Integer Vacation_days;
    @Column (nullable = false)
    private Integer Available_vacation_days;
    @Column (nullable = false)
    private Integer Available_study_days;
    @Nullable
    private String supervisor;



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
        HashMap<String, Object> authDetails = (HashMap<String, Object>) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String creatorId =  (String) authDetails.get("userId");
        this.setCreated_by(creatorId);

        //Set supervisor id
        this.setSupervisor(creatorId);

        //Encrypt and save the password
        //BCrypt strong hashing function (SHA1)
        this.setPassword(new BCryptPasswordEncoder().encode(this.password));
        this.setOldPassword(this.password);
    }
    @PreUpdate
    public void preUpdate(){


        //Configure audit data
        HashMap<String, Object> authDetails = (HashMap<String, Object>) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String updaterId =  (String) authDetails.get("userId");
        this.setUpdated_by(updaterId);

        //CHECK IF PASSWORD WAS UPDATED. IN THAT CASE, UPDATE passwordLastUpdate field to invalidate generated JWTs.
        if (!this.password.equals(this.oldPassword)) {
            this.setPassword(new BCryptPasswordEncoder().encode(this.password));
            this.setOldPassword(this.password);
            this.setPasswordLastUpdate(Instant.now());
        }
    }

}
