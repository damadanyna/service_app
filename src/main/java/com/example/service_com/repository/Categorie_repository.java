package com.example.service_com.repository;

import java.util.Optional;

import com.example.service_com.model.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Categorie_repository extends JpaRepository<Categorie, Integer> {

    Optional<Categorie> findById(String categorieId);

    Optional<Categorie> findById(Categorie categorie);

}
