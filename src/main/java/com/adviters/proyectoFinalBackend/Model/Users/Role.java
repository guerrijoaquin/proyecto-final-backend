package com.adviters.proyectoFinalBackend.Model.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@AutoConfiguration
public class Role {

    @Id @GeneratedValue
    private String id;

    @Column (nullable = false)
    private String role_name;

    @CreationTimestamp
    @Column (updatable = false)
    private Timestamp Created_at;
    @Column (updatable = false)
    private String Created_by;
    @Nullable
    @UpdateTimestamp
    private Timestamp Updated_at;
    @Nullable
    private String Updated_by;

}
