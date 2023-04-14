package com.adviters.proyectoFinalBackend.Models.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)

public class Usuario {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @NonNull
    private String name;
    @NonNull
    private String lastname;
    @NonNull
    private String password;
    @NonNull
    @Column (unique = true)
    private String mail;
    @NonNull
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
    @NonNull
    private Integer Role_id;
    @NonNull
    private Date Birth_date;
    @NonNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date Start_working_date;
    @NonNull
    private Integer Vacation_days;
    @NonNull
    private Integer Available_vacation_days;
    @NonNull
    private Integer Available_study_days;
    @Nullable
    private String supervisor;
    @NonNull
    @CreationTimestamp
    @Column (updatable = false)
    private Timestamp Created_at;
    @NonNull
    @Column (updatable = false)
    private String Created_by;
    @Nullable
    @UpdateTimestamp
    private Timestamp Updated_at;
    @Nullable
    private String Updated_by;

}
