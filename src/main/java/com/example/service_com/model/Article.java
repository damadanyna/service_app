package com.example.service_com.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Locale.Category;

import javax.persistence.*;

@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100)
    private String ref_article;
    @Column(length = 100)
    private String nom_article;
    @Column(length = 100)
    private String lib_article;
    private double prix_unit_article;
    private double qt_stock_article;
    private boolean disp_article;
    
    @OneToMany
    private Fournisseur fournisseur;
    
    @OneToMany
    private Category category;


    @ManyToMany
    @JoinTable(name = "liste_articles",
                joinColumns = @JoinColumn(name = "id"),
                inverseJoinColumns = @JoinColumn(name = "qt_commande"))
    private List<Article> articles= new ArrayList<>();
    
    public Article() {
    }

    public String getRef_article() {
        return this.ref_article;
    }

    public void setRef_article(String ref_article) {
        this.ref_article = ref_article;
    }

    public String getNom_article() {
        return this.nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public String getLib_article() {
        return this.lib_article;
    }

    public void setLib_article(String lib_article) {
        this.lib_article = lib_article;
    }

    public double getPrix_unit_article() {
        return this.prix_unit_article;
    }

    public void setPrix_unit_article(double prix_unit_article) {
        this.prix_unit_article = prix_unit_article;
    }

    public double getQt_stock_article() {
        return this.qt_stock_article;
    }

    public void setQt_stock_article(double qt_stock_article) {
        this.qt_stock_article = qt_stock_article;
    }

    public boolean isDisp_article() {
        return this.disp_article;
    }

    public boolean getDisp_article() {
        return this.disp_article;
    }

    public void setDisp_article(boolean disp_article) {
        this.disp_article = disp_article;
    }

}
