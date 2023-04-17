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
    @JoinColumn (name = "idLicenceType", referencedColumnName = "id")
    private TipoDeLicencia tipoDeLicencia;

    @Column (nullable = false)
    private Date startDate;

    @Column (nullable = false)
    private Date endDate;

//    @Column (nullable = false)
//    private Integer status;
    @ManyToOne
    @JoinColumn (name = "status", referencedColumnName = "id", columnDefinition = "default 0")
    private TipoDeEstadoDeSolicitud tipoDeEstadoDeSolicitud;

    @Column (nullable = false)
    private Integer totalAvailableDays;

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

        HashMap<String, Object> map1 = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("id", 0);
        map1.put(map2);
         this.setTipoDeEstadoDeSolicitud(new TipoDeEstadoDeSolicitud(0));
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
