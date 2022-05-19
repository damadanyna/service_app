package com.example.service_com.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_en",length = 3)
public abstract class Entreprise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_en;
    private String nom_en;
    private String adresse_en;
    private int code_en;
    private String contacte_en;

    public Entreprise() {
    }

    public int getId_en() {
        return this.id_en;
    }

    public void setId_en(int id_en) {
        this.id_en = id_en;
    }

    public String getNom_en() {
        return this.nom_en;
    }

    public void setNom_en(String nom_en) {
        this.nom_en = nom_en;
    }

    public String getAdresse_en() {
        return this.adresse_en;
    }

    public void setAdresse_en(String adresse_en) {
        this.adresse_en = adresse_en;
    }

    public int getCode_en() {
        return this.code_en;
    }

    public void setCode_en(int code_en) {
        this.code_en = code_en;
    }

    public String getContacte_en() {
        return this.contacte_en;
    }

    public void setContacte_en(String contacte_en) {
        this.contacte_en = contacte_en;
    }

}
