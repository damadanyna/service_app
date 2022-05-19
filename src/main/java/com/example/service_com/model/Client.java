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

    @OneToMany(mappedBy = "client")
    private List<Commande> liste_commande = new ArrayList<>();
}
