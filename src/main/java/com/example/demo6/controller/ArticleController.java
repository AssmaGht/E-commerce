package com.example.demo6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo6.entitie.Article;

import com.example.demo6.repository.ArticleRepository;

@RestController
@RequestMapping("Article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRep;

    @PostMapping("ajouter")
    public String Addarticle(@RequestBody Article article) {
        this.articleRep.save(article);
        return "Article ajouté avec succès";
    }

    @GetMapping("afficher")
    public List<Article> listarticle() {
        return this.articleRep.findAll();
    }
    @GetMapping("Afficherbyid")
    public Article afficherid(Long id) {
    
    Article article =this.articleRep.findById(id).get();
    return article;
    }
    
    @PutMapping("modifier/{id}")
    public String updatearticle( Long id, @RequestBody Article articleDetails) {
        Article article = this.articleRep.findById(id).get();
        
        article.setNom(articleDetails.getNom());
        article.setDescription(articleDetails.getDescription());
        article.setPrix(articleDetails.getPrix());
        article.setQte(articleDetails.getQte());
        article.setDateajout(articleDetails.getDateajout());
        article.setStockstatus(articleDetails.getStockstatus());
        article.setCodepromo(articleDetails.getCodepromo());
        this.articleRep.saveAndFlush(article);
        return "Article modifié avec succès";
    }


    
    
    @PutMapping("archiver")
    public String Archiver(Long id ) {
    	
    	Article article =this.articleRep.findById(id).get();
    	 article.setStockstatus("reputrestock");
         this.articleRep.saveAndFlush(article);
         return "Article désarchivé avec succès";
    }
    
    
    @PutMapping("desarchiver")
    public String desArchiver(Long id ) {
    	
    	Article article =this.articleRep.findById(id).get();
   	 article.setStockstatus("disponible");
        this.articleRep.saveAndFlush(article);
        return "Article désarchivé avec succès";
    }

@GetMapping("listarchiver")
public List<Article> listarchiver(){
	
	List<Article> art=	this.articleRep.findByStockstatus("reputrestock");
	
	return art;
}

@GetMapping("listdesarchiver")
public List<Article> listdesarchiver(){
	
	return this.articleRep.findByStockstatus("disponible");
}
}

