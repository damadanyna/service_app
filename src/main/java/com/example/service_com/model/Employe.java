package com.example.service_com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    @Column(length = 100)
    private String date_naiss_employe;
    @Column(length = 100)
    private String date_emboche_employe;
    private double saliare;
    private double commision;

    @OneToMany(mappedBy = "employe")
    List<Commande> liste_commande;

    public Employe() {
    }

    public Employe(int id_employe, String nom_employe, String prenom_employe, String fonction_employe, String date_naiss_employe, String date_emboche_employe, double saliare, double commision, List<Commande> liste_commande) {
        this.id_employe = id_employe;
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
        this.fonction_employe = fonction_employe;
        this.date_naiss_employe = date_naiss_employe;
        this.date_emboche_employe = date_emboche_employe;
        this.saliare = saliare;
        this.commision = commision;
        this.liste_commande = liste_commande;
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

    public String getDate_naiss_employe() {
        return this.date_naiss_employe;
    }

    public void setDate_naiss_employe(String date_naiss_employe) {
        this.date_naiss_employe = date_naiss_employe;
    }

    public String getDate_emboche_employe() {
        return this.date_emboche_employe;
    }

    public void setDate_emboche_employe(String date_emboche_employe) {
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

    public List<Commande> getListe_commande() {
        return this.liste_commande;
    }

    public void setListe_commande(List<Commande> liste_commande) {
        this.liste_commande = liste_commande;
    }

}