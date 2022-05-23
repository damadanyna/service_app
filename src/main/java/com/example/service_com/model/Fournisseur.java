package com.example.service_com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("fou")
public class Fournisseur extends Entreprise implements Serializable {


    public Fournisseur() {
    }


    public Fournisseur(String nom_en, String adresse_en, String contacte_en, String ville) {
        super(nom_en, adresse_en, contacte_en, ville);
        // TODO Auto-generated constructor stub
    }

    @OneToMany(mappedBy = "fournisseur")
    private List<Article> liste_fournisseur = new ArrayList<>();
}
