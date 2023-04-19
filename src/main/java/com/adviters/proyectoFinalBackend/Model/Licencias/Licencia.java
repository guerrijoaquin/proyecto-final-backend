package com.adviters.proyectoFinalBackend.Model.Licencias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@AutoConfiguration
public class Licencia {

    @Id @GeneratedValue
    private Integer id;

    @Column (nullable = false)
    private String idUser;

//    @Column (nullable = false)
//    private Integer idLicenceType;
    @ManyToOne
    @JoinColumn (name = "idLicenceType")
    private TipoDeLicencia tipoDeLicencia;

    @Column (nullable = false)
    private LocalDate startDate;

    @Column (nullable = false)
    private LocalDate endDate;

//    @Column (nullable = false)
//    private Integer status;
    @ManyToOne
    @JoinColumn (name = "status", referencedColumnName = "id" , columnDefinition = "int default 0")
    private TipoDeEstadoDeSolicitud tipoDeEstadoDeSolicitud;

    @Column (nullable = false)
    private Integer totalAvailableDays;

    @Column (nullable = false)
    private String supervisor;

    //ADD DOCUMENTATION FIELD

    //AUDIT DATA
    @CreationTimestamp
    @JsonIgnore
    @Column(updatable = false, nullable = false)
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

        //Set default values
//        this.setStatus(0);
    }
    @PreUpdate
    public void preUpdate(){

        //Configure audit data
        HashMap<String, Object> authDetails = (HashMap<String, Object>) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String updaterId =  (String) authDetails.get("userId");
        this.setUpdated_by(updaterId);
    }
}
