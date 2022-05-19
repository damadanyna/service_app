package com.example.service_com.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fou")
public class Fournisseur extends Entreprise implements Serializable {

}
