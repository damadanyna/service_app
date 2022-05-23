package com.example.service_com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_en", length = 3)
public abstract class Entreprise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_en;
    @Column(length = 150)
    private String nom_en;
    @Column(length = 150)
    private String adresse_en;
    @Column(nullable = true)
    private int code_postal_en;
    @Column(length = 150)
    private String contacte_en;
    @Column(length = 150)
    private String ville;

    public Entreprise() {
    }


    public Entreprise(String nom_en, String adresse_en, String contacte_en, String ville) {
        this.nom_en = nom_en;
        this.adresse_en = adresse_en;
        this.contacte_en = contacte_en;
        this.ville = ville;
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

    public int getCode_postal_en() {
        return this.code_postal_en;
    }

    public void setCode_postal_en(int code_postal_en) {
        this.code_postal_en = code_postal_en;
    }

    public String getContacte_en() {
        return this.contacte_en;
    }

    public void setContacte_en(String contacte_en) {
        this.contacte_en = contacte_en;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}
