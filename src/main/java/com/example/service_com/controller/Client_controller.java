package com.example.service_com.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.service_com.model.Client;
import com.example.service_com.repository.Client_repository;
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
public class Client_controller {
    @Autowired
    Client_repository client_repository;

    // Get All client
    @GetMapping("/all_cli")
    public List<Client> getAllClients() {
        return client_repository.findAll();
    }

    // Create a new client
    @PostMapping(path = "/add_cli")
    public Client createClient(@Valid Client client) {
        return client_repository.save(client);
    }

    // Get a Single Client
    @GetMapping("/on_cli/{id}")
    public Client getCategorieById(@PathVariable(value = "id") Integer clientId) {
        return client_repository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", clientId));
    }

    // Update a Article
    @PostMapping("/on_cli/{id}")
    public Client updatClient(@PathVariable(value = "id") Integer clientId,
            @Valid Client clientDetails) {

        Client client = client_repository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("client", "id", clientId));

        client.setNom_en(clientDetails.getNom_en());
        client.setCode_postal_en(clientDetails.getCode_postal_en());
        client.setContacte_en(clientDetails.getContacte_en());
        client.setAdresse_en(clientDetails.getAdresse_en());
        client.setVille(clientDetails.getVille());

        Client updatedclient = client_repository.save(client);
        return updatedclient;
    }

    // Delete a Client
    @PostMapping("/del_cli/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Integer clientId) {
        Client client = client_repository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));

        client_repository.delete(client);

        return ResponseEntity.ok().build();
    }

}
