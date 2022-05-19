package com.example.service_com.repository;

import java.util.Optional;

import com.example.service_com.model.Commande;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Commande_repository extends JpaRepository<Commande,Integer>{

    Optional<Commande> findById(Integer commandeId);
    
}
