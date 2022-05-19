package com.example.service_com.repository;

import java.util.Optional;

import com.example.service_com.model.Article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Article_repository extends JpaRepository<Article,String>{

    Optional<Article> findById(String articleId);
    
}
