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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class Client_controller {
    @Autowired
    Client_repository client_repository;

    // Get All client
    @GetMapping("/all_client")
    public List<Client> getAllClients() {
        return client_repository.findAll();
    }

    // Create a new client
    @PostMapping("/all_client")
    public Client createClient(@Valid @RequestBody Client client) {
        return client_repository.save(client);
    }

    // Get a Single Client
    @GetMapping("/on_cli/{id}")
    public Client getCategorieById(@PathVariable(value = "id") Integer clientId) {
        return client_repository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", clientId));
    }

    // Update a Article
    @PutMapping("/on_com/{id}")
    public Client updateCommande(@PathVariable(value = "id") Integer commandeId,
            @Valid @RequestBody Client commandeDetails) {

        Client commande = client_repository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("commande", "id", commandeId));

        commande.setNom_en(commandeDetails.getNom_en());
        commande.setContacte_en(commandeDetails.getContacte_en());

        Client updatedcommande = client_repository.save(commande);
        return updatedcommande;
    }

    // Delete a Client
    @DeleteMapping("/on_cli/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Integer clientId) {
        Client client = client_repository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));

        client_repository.delete(client);

        return ResponseEntity.ok().build();
    }

}
