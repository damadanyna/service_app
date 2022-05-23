package com.example.service_com.repository;

import java.util.Optional;

import com.example.service_com.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Client_repository extends JpaRepository<Client, Integer> {

    Optional<Client> findById(Integer clientId);
}
