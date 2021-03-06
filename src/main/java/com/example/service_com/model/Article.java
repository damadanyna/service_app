package com.example.service_com.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

import javax.persistence.*;

@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ref_article ;
    @Column(length = 100)
    private String nom_article;
    @Column(length = 100)
    private String lib_article;
    private double prix_unit_article;
    private double qt_stock_article;
    private boolean disp_article;

    @ManyToMany
    @JoinTable(name = "liste_articles", joinColumns = @JoinColumn(name = "ref_article"), inverseJoinColumns = @JoinColumn(name = "qt_commande"))
    private List<Article> articles = new ArrayList<>();

    @ManyToOne
    private Fournisseur fournisseur;

    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "article")
    private List<Commande> liste_commande = new ArrayList<>();

    public Article() {
    }

    public Article(int ref_article, String nom_article, String lib_article, double prix_unit_article, double qt_stock_article, boolean disp_article, List<Article> articles, Fournisseur fournisseur, Categorie categorie, List<Commande> liste_commande) {
        this.ref_article = ref_article;
        this.nom_article = nom_article;
        this.lib_article = lib_article;
        this.prix_unit_article = prix_unit_article;
        this.qt_stock_article = qt_stock_article;
        this.disp_article = disp_article;
        this.articles = articles;
        this.fournisseur = fournisseur;
        this.categorie = categorie;
        this.liste_commande = liste_commande;
    }

    public int getRef_article() {
        return this.ref_article;
    }

    public void setRef_article(int ref_article) {
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

    public List<Article> getArticles() {
        return this.articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Fournisseur getFournisseur() {
        return this.fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Commande> getListe_commande() {
        return this.liste_commande;
    }

    public void setListe_commande(List<Commande> liste_commande) {
        this.liste_commande = liste_commande;
    }

}