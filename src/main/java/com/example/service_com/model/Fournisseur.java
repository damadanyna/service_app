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

    @OneToMany(mappedBy = "fournisseur")
    private List<Article> liste_fournisseur = new ArrayList<>();
}
