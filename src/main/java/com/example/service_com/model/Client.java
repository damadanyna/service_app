package com.example.service_com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("cli")
public class Client extends Entreprise implements Serializable {

    public Client() {
    }
    
    public Client(String nom_en, String adresse_en, int code_postal_en, String contacte_en, String ville) {
        super(nom_en, adresse_en, contacte_en, ville);
        // TODO Auto-generated constructor stub
    }

    @OneToMany(mappedBy = "client")
    private List<Commande> liste_commande = new ArrayList<>();

}
