package com.example.service_com.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.service_com.model.Employe;
import com.example.service_com.repository.Employe_repository;
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
@RequestMapping("/api")
public class Employe_controller {
    @Autowired
    Employe_repository employe_repository;

    // Get All Categorie
    @GetMapping("/all_emp")
    public List<Employe> getAllCommandes() {
        return employe_repository.findAll();
    }

    // Create a new Commande
    @PostMapping("/all_emp")
    public Employe createCommande(@Valid  Employe employe) {
        return employe_repository.save(employe);
    }

    // Get a Single Commande
    @GetMapping("/on_emp/{id}")
    public Employe getEmployeById(@PathVariable(value = "id") Integer commandeId) {
        return employe_repository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", commandeId));
    }

    // Update a Article
    @PostMapping("/on_emp/{id}")
    public Employe updateCommande(@PathVariable(value = "id") Integer employeId,
            @Valid  Employe CommandeDetails) {

        Employe employe = employe_repository.findById(employeId)
                .orElseThrow(() -> new ResourceNotFoundException("commande", "id", employeId));
                employe.setSaliare(employe.getSaliare());
                employe.setCommision(employe.getCommision());
                employe.setNom_employe(employe.getNom_employe());
                employe.setPrenom_employe(employe.getPrenom_employe());
                employe.setFonction_employe(employe.getFonction_employe());
                employe.setDate_naiss_employe(employe.getDate_naiss_employe());
                employe.setDate_emboche_employe(employe.getDate_emboche_employe());

        Employe updatedEmploye = employe_repository.save(employe);
        return updatedEmploye;
    }

    // Delete a Note
    @PostMapping("/del_emp/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer noteId) {
        Employe employe = employe_repository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        employe_repository.delete(employe);

        return ResponseEntity.ok().build();
    }
}
