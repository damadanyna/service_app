package com.example.service_com.model;

import java.io.Serializable;
import java.util.Date;

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
    private Date date_commande;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Employe employe;

    @OneToOne
    private Article article;

    public Commande() {
    }

    public int getNum_commande() {
        return this.num_commande;
    }

    public void setNum_commande(int num_commande) {
        this.num_commande = num_commande;
    }

    public Date getDate_commande() {
        return this.date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

}
