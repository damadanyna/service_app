package com.example.service_com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num_commande;
    private String date_commande;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Employe employe;

    @OneToOne
    private Article article;

    public Commande() {
    }

    public Commande(int num_commande, String date_commande, Client client, Employe employe, Article article) {
        this.num_commande = num_commande;
        this.date_commande = date_commande;
        this.client = client;
        this.employe = employe;
        this.article = article;
    }


    public int getNum_commande() {
        return this.num_commande;
    }

    public void setNum_commande(int num_commande) {
        this.num_commande = num_commande;
    }

    public String getDate_commande() {
        return this.date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }

}
