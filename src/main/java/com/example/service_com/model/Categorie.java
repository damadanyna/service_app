package com.example.service_com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code_cat;

    @Column(length = 150)
    private String nom_cat;

    private String descript_cat;

    public Categorie() {
    }

    public int getCode_cat() {
        return this.code_cat;
    }

    public void setCode_cat(int code_cat) {
        this.code_cat = code_cat;
    }

    public String getNom_cat() {
        return this.nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public String getDescript_cat() {
        return this.descript_cat;
    }

    public void setDescript_cat(String descript_cat) {
        this.descript_cat = descript_cat;
    }

}
