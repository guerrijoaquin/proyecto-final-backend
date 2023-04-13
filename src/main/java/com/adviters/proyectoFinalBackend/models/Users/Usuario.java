package com.adviters.proyectoFinalBackend.models.Users;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table
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
    private String mail;
    @NonNull
    private Integer phone;
    @Nullable
    private String street;
    @Nullable
    private Integer Street_number;
    @Nullable
    private String town;
    @Nullable
    private String state;
    @Nullable
    private String country;
    @Lob
    @Nullable
    private Blob Profile_picture;
    @Nullable
    private Integer Role_id;
    @Nullable
    private Date Birth_date;
    @Nullable
    private Date Start_working_date;
    @Nullable
    private Integer Vacation_days;
    @Nullable
    private Integer Available_vacation_days;
    @Nullable
    private Integer Available_study_days;
    @Nullable
    private String supervisor;
    @Nullable
    private Timestamp Created_at;
    @Nullable
    private String Created_by;
    @Nullable
    private Timestamp Updated_at;
    @Nullable
    private String Updated_by;

    public Usuario(String id, @NonNull String name, @NonNull String lastname, @NonNull String password, @NonNull String mail, @NonNull Integer phone, @Nullable String street, @Nullable Integer street_number, @Nullable String town, @Nullable String state, @Nullable String country, @Nullable Blob profile_picture, @Nullable Integer role_id, @Nullable Date birth_date, @Nullable Date start_working_date, @Nullable Integer vacation_days, @Nullable Integer available_vacation_days, @Nullable Integer available_study_days, @Nullable String supervisor, @Nullable Timestamp created_at, @Nullable String created_by, @Nullable Timestamp updated_at, @Nullable String updated_by) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.street = street;
        Street_number = street_number;
        this.town = town;
        this.state = state;
        this.country = country;
        Profile_picture = profile_picture;
        Role_id = role_id;
        Birth_date = birth_date;
        Start_working_date = start_working_date;
        Vacation_days = vacation_days;
        Available_vacation_days = available_vacation_days;
        Available_study_days = available_study_days;
        this.supervisor = supervisor;
        Created_at = created_at;
        Created_by = created_by;
        Updated_at = updated_at;
        Updated_by = updated_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(@NonNull String lastname) {
        this.lastname = lastname;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getMail() {
        return mail;
    }

    public void setMail(@NonNull String mail) {
        this.mail = mail;
    }

    @NonNull
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(@NonNull Integer phone) {
        this.phone = phone;
    }

    @Nullable
    public String getStreet() {
        return street;
    }

    public void setStreet(@Nullable String street) {
        this.street = street;
    }

    @Nullable
    public Integer getStreet_number() {
        return Street_number;
    }

    public void setStreet_number(@Nullable Integer street_number) {
        Street_number = street_number;
    }

    @Nullable
    public String getTown() {
        return town;
    }

    public void setTown(@Nullable String town) {
        this.town = town;
    }

    @Nullable
    public String getState() {
        return state;
    }

    public void setState(@Nullable String state) {
        this.state = state;
    }

    @Nullable
    public String getCountry() {
        return country;
    }

    public void setCountry(@Nullable String country) {
        this.country = country;
    }

    @Nullable
    public Blob getProfile_picture() {
        return Profile_picture;
    }

    public void setProfile_picture(@Nullable Blob profile_picture) {
        Profile_picture = profile_picture;
    }

    @Nullable
    public Integer getRole_id() {
        return Role_id;
    }

    public void setRole_id(@Nullable Integer role_id) {
        Role_id = role_id;
    }

    @Nullable
    public Date getBirth_date() {
        return Birth_date;
    }

    public void setBirth_date(@Nullable Date birth_date) {
        Birth_date = birth_date;
    }

    @Nullable
    public Date getStart_working_date() {
        return Start_working_date;
    }

    public void setStart_working_date(@Nullable Date start_working_date) {
        Start_working_date = start_working_date;
    }

    @Nullable
    public Integer getVacation_days() {
        return Vacation_days;
    }

    public void setVacation_days(@Nullable Integer vacation_days) {
        Vacation_days = vacation_days;
    }

    @Nullable
    public Integer getAvailable_vacation_days() {
        return Available_vacation_days;
    }

    public void setAvailable_vacation_days(@Nullable Integer available_vacation_days) {
        Available_vacation_days = available_vacation_days;
    }

    @Nullable
    public Integer getAvailable_study_days() {
        return Available_study_days;
    }

    public void setAvailable_study_days(@Nullable Integer available_study_days) {
        Available_study_days = available_study_days;
    }

    @Nullable
    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(@Nullable String supervisor) {
        this.supervisor = supervisor;
    }

    @Nullable
    public Timestamp getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(@Nullable Timestamp created_at) {
        Created_at = created_at;
    }

    @Nullable
    public String getCreated_by() {
        return Created_by;
    }

    public void setCreated_by(@Nullable String created_by) {
        Created_by = created_by;
    }

    @Nullable
    public Timestamp getUpdated_at() {
        return Updated_at;
    }

    public void setUpdated_at(@Nullable Timestamp updated_at) {
        Updated_at = updated_at;
    }

    @Nullable
    public String getUpdated_by() {
        return Updated_by;
    }

    public void setUpdated_by(@Nullable String updated_by) {
        Updated_by = updated_by;
    }
}
