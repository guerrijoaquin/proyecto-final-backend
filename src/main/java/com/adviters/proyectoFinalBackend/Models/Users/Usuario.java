package com.adviters.proyectoFinalBackend.Models.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

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
    @NonNull
    @NaturalId
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
    private Date Birth_date;
    @NonNull
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

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
        HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
        fact.setEntityManagerFactory(emf);
        return fact;
    }

}
