package com.example.service_com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_employe;

    @Column(length = 100)
    private String nom_employe;

    @Column(length = 100)
    private String prenom_employe;

    @Column(length = 100)
    private String fonction_employe;
    private Date date_naiss_employe;
    private Date date_emboche_employe;
    private double saliare;
    private double commision;

    public Employe() {
    }

    

    public int getId_employe() {
        return this.id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public String getNom_employe() {
        return this.nom_employe;
    }

    public void setNom_employe(String nom_employe) {
        this.nom_employe = nom_employe;
    }

    public String getPrenom_employe() {
        return this.prenom_employe;
    }

    public void setPrenom_employe(String prenom_employe) {
        this.prenom_employe = prenom_employe;
    }

    public String getFonction_employe() {
        return this.fonction_employe;
    }

    public void setFonction_employe(String fonction_employe) {
        this.fonction_employe = fonction_employe;
    }

    public Date getDate_naiss_employe() {
        return this.date_naiss_employe;
    }

    public void setDate_naiss_employe(Date date_naiss_employe) {
        this.date_naiss_employe = date_naiss_employe;
    }

    public Date getDate_emboche_employe() {
        return this.date_emboche_employe;
    }

    public void setDate_emboche_employe(Date date_emboche_employe) {
        this.date_emboche_employe = date_emboche_employe;
    }

    public double getSaliare() {
        return this.saliare;
    }

    public void setSaliare(double saliare) {
        this.saliare = saliare;
    }

    public double getCommision() {
        return this.commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }

}