package com.example.service_com.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.service_com.model.Article;
import com.example.service_com.repository.Article_repository;
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
@RequestMapping("/article")
public class Article_controller {
    @Autowired
    Article_repository article_repository;

    // Get All Article
    @GetMapping("/all")
    public List<Article> getAllArticles() {
        return article_repository.findAll();
    }

    // Create a new Article
    @PostMapping("/all")
    public Article createArticle(@Valid @RequestBody Article article) {
        return article_repository.save(article);
    }

    // Get a Single Article
    @GetMapping("/on/{id}")
    public Article getArticleById(@PathVariable(value = "id") String ArticleId) {
        return article_repository.findById(ArticleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", ArticleId));
    }

    // Update a Article
    @PutMapping("/on/{id}")
    public Article updateArticle(@PathVariable(value = "id") String ArticleId,
            @Valid @RequestBody Article ArticleDetails) {

        Article Article = article_repository.findById(ArticleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", ArticleId));

        Article.setRef_article(ArticleDetails.getRef_article());
        Article.setQt_stock_article(ArticleDetails.getQt_stock_article());

        Article updatedArticle = article_repository.save(Article);
        return updatedArticle;
    }

    // Delete a Article
    @DeleteMapping("/on/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable(value = "id") String articleId) {
        Article article = article_repository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("article", "id", articleId));

        article_repository.delete(article);

        return ResponseEntity.ok().build();
    }
}
