package com.example.service_com.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.service_com.model.Client;
import com.example.service_com.repository.Client_repository;
import com.example.service_com.resourceNotFoundException.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class Client_controller {
    @Autowired
    Client_repository client_repository;

    // Get All client
    @GetMapping("/all")
    public List<Client> getAllClients() {
        return client_repository.findAll();
    }

    // Create a new client
    @PostMapping("/all")
    public Client createClient(@Valid @RequestBody Client client) {
        return client_repository.save(client);
    }

    // Get a Single Categorie
    @GetMapping("/on/{id}")
    public Client getCategorieById(@PathVariable(value = "id") Integer categorieId) {
        return client_repository.findById(categorieId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", categorieId));
    }

    // Delete a Note
    @DeleteMapping("/on/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer clientId) {
        Client client = client_repository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", clientId));

        client_repository.delete(client);

        return ResponseEntity.ok().build();
    }

}
