package com.example.service_com.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.service_com.model.Categorie;
import com.example.service_com.repository.Categorie_repository;
import com.example.service_com.resourceNotFoundException.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Categorie_controller {
    @Autowired
    Categorie_repository categorie_repository;

    // Get All Categorie
    @GetMapping("/all_cat")
    public List<Categorie> getAllCategories() {
        return categorie_repository.findAll();
    }

    // Create a new Categorie
    @PostMapping(path = "/all_cat")
    public Categorie createCategorie(Categorie categorie) {
        return categorie_repository.save(categorie);
    }

    // Get a Single Categorie
    @GetMapping("/on_cat/{id}")
    public Categorie getCategorieById(@PathVariable(value = "id") Integer categorieId) {
        return categorie_repository.findById(categorieId)
                .orElseThrow(() -> new ResourceNotFoundException("categorie", "id", categorieId));
    }

    // Update a Article
    @PostMapping("/on_cat/{id}")
    public Categorie updateCategorie(@PathVariable(value = "id") Integer categorieId,
            @Valid Categorie CategorieDetails) {

        Categorie categorie = categorie_repository.findById(categorieId)
                .orElseThrow(() -> new ResourceNotFoundException("categorie", "id", categorieId));

        categorie.setDescript_cat(CategorieDetails.getDescript_cat());
        categorie.setNom_cat(CategorieDetails.getNom_cat());

        Categorie updatedCategorie = categorie_repository.save(categorie);
        return updatedCategorie;
    }

    // Delete a Categorie
    @PostMapping("/del_cat/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable(value = "id") Integer categorieId) {
        Categorie categorie = categorie_repository.findById(categorieId)
                .orElseThrow(() -> new ResourceNotFoundException("categorie", "id", categorieId));

        categorie_repository.delete(categorie);

        return ResponseEntity.ok().build();
    }
}
