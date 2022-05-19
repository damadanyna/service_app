package com.example.service_com.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.service_com.model.Categorie;
import com.example.service_com.repository.Categorie_repository;
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
public class Categorie_controller {
    @Autowired
    Categorie_repository categorie_repository;

    // Get All Categorie
    @GetMapping("/all")
    public List<Categorie> getAllCategories() {
        return categorie_repository.findAll();
    }

    // Create a new Categorie
    @PostMapping("/all")
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {
        return categorie_repository.save(categorie);
    }

    // Get a Single Categorie
    @GetMapping("/on/{id}")
    public Categorie getCategorieById(@PathVariable(value = "id") Integer categorieId) {
        return categorie_repository.findById(categorieId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", categorieId));
    }

    // Update a Article
    @PutMapping("/on/{id}")
    public Categorie updateCategorie(@PathVariable(value = "id") Integer categorieId,
            @Valid @RequestBody Categorie CategorieDetails) {

        Categorie categorie = categorie_repository.findById(categorieId)
                .orElseThrow(() -> new ResourceNotFoundException("Categorie", "id", categorieId));

        categorie.setDescript_cat(CategorieDetails.getDescript_cat());
        categorie.setNom_cat(CategorieDetails.getNom_cat());

        Categorie updatedCategorie = categorie_repository.save(categorie);
        return updatedCategorie;
    }

    // Delete a Categorie
    @DeleteMapping("/on/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer noteId) {
        Categorie categorie = categorie_repository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        categorie_repository.delete(categorie);

        return ResponseEntity.ok().build();
    }
}
