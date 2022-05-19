package com.example.service_com.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.service_com.model.Commande;
import com.example.service_com.repository.Commande_repository;
import com.example.service_com.resourceNotFoundException.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorie")
public class Commande_controller {
    @Autowired
    Commande_repository commande_repository;

    // Get All Categorie
    @GetMapping("/all")
    public List<Commande> getAllCommandes() {
        return commande_repository.findAll();
    }

    // Create a new Commande
    @PostMapping("/all")
    public Commande createCommande(@Valid @RequestBody Commande commande) {
        return commande_repository.save(commande);
    }

    // Get a Single Commande
    @GetMapping("/on/{id}")
    public Commande getCommandeById(@PathVariable(value = "id") Integer commandeId) {
        return commande_repository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", commandeId));
    }

    // Update a Article
    @PutMapping("/on/{id}")
    public Commande updateCommande(@PathVariable(value = "id") Integer commandeId,
            @Valid @RequestBody Commande CommandeDetails) {

        Commande commande = commande_repository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("commande", "id", commandeId));

        commande.setDate_commande(CommandeDetails.getDate_commande());
        commande.setNum_commande(CommandeDetails.getNum_commande());

        Commande updatedCommande = commande_repository.save(commande);
        return updatedCommande;
    }

    // Delete a Note
    @DeleteMapping("/on/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer commandeId) {
        Commande commande = commande_repository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", commandeId));

        commande_repository.delete(commande);

        return ResponseEntity.ok().build();
    }
}
