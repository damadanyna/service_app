package com.example.service_com.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cli")
public class Client extends Entreprise implements Serializable {

}
