package com.example.service_com.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.service_com.model.Fournisseur;
import com.example.service_com.repository.Fournisseur_repository;
import com.example.service_com.resourceNotFoundException.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Fournisseur_controller {
    @Autowired
    Fournisseur_repository fournisseur_repository;

    // Get All Categorie
    @GetMapping("/all_fourn")
    public List<Fournisseur> getAllCommandes() {
        return fournisseur_repository.findAll();
    }

    // Create a new Commande
    @PostMapping("/all_fourn")
    public Fournisseur createCommande(@Valid Fournisseur fournisseur) {
        return fournisseur_repository.save(fournisseur);
    }

    // Get a Single Commande
    @GetMapping("/one_fourn/{id}")
    public Fournisseur getFournisseurById(@PathVariable(value = "id") Integer fournisseurId) {
        return fournisseur_repository.findById(fournisseurId)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur", "id", fournisseurId));
    }

    // Update a Article
    @PostMapping("/add_fourn/{id}")
    public Fournisseur updateCommande(@PathVariable(value = "id") Integer fournisseurId,
            @Valid Fournisseur FournisseurDetails) {

        Fournisseur fournisseur = fournisseur_repository.findById(fournisseurId)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur", "id", fournisseurId));

        fournisseur.setAdresse_en(FournisseurDetails.getAdresse_en());
        fournisseur.setNom_en(FournisseurDetails.getNom_en());

        Fournisseur updatedFournisseur = fournisseur_repository.save(fournisseur);
        return updatedFournisseur;
    }

    // Delete a Note
    @PostMapping("/one_fourn/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer noteId) {
        Fournisseur fournisseur = fournisseur_repository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        fournisseur_repository.delete(fournisseur);

        return ResponseEntity.ok().build();
    }

}
