package com.example.service_com.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.service_com.model.Article;
import com.example.service_com.repository.Article_repository;
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
public class Article_controller {
    @Autowired
    Article_repository article_repository;

    // Get All Article
    @GetMapping("/all_art")
    public List<Article> getAllArticles() {
        return article_repository.findAll();
    }

    // Create a new Article
    @PostMapping("/all_art")
    public Article createArticle( Article article) {
        return article_repository.save(article);
    }

    // Get a Single Article
    @GetMapping("/on_art/{id}")
    public Article getArticleById(@PathVariable(value = "id") Integer ArticleId) {
        return article_repository.findById(ArticleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", ArticleId));
    }

    // Update a Article
    @PostMapping("/on_art/{id}")
    public Article updateArticle(@PathVariable(value = "id") Integer ArticleId,
             Article ArticleDetails) {

        Article article = article_repository.findById(ArticleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", ArticleId));

                article.setLib_article(article.getLib_article());
                article.setNom_article(article.getNom_article());
                article.setPrix_unit_article(article.getPrix_unit_article());
                article.setQt_stock_article(article.getQt_stock_article());
                article.setCategorie(article.getCategorie());
                article.setFournisseur(article.getFournisseur());
                article.setDisp_article(article.getDisp_article());

        Article updatedArticle = article_repository.save(article);
        return updatedArticle;
    }

    // Delete a Article
    @PostMapping("/del_art/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable(value = "id") Integer articleId) {
        Article article = article_repository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("article", "id", articleId));
        article_repository.delete(article);
        return ResponseEntity.ok().build();
    }
}
