package com.example.demo6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo6.entitie.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

	List<Article> findByStockstatus(String string);






}
