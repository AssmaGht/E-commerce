package com.example.demo6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.entitie.Categorie;
import com.example.demo6.repository.CategorieRepository;

@RestController
@RequestMapping("Categorie")
public class CategorieController {

    @Autowired
    private CategorieRepository categorieRep;

    @PostMapping("ajouter")
    public String addCategorie(@RequestBody Categorie categorie) {
        categorieRep.save(categorie);
        return "Catégorie ajoutée avec succès";
    }

    @GetMapping("afficher")
    public List<Categorie> listCategories() {
        return categorieRep.findAll();
    }
    
    

    @PutMapping("modifier/{id}")
    public String updatecateg( Long id, @RequestBody Categorie cat) {
     Categorie categ = this.categorieRep.findById(id).get();
        
     categ.setNom(cat.getNom());
     categ.setDescription(cat.getDescription());
     this.categorieRep.saveAndFlush(categ);
     return "categorie modifié avec succès";
    }
    
    
    @GetMapping("Afficherbyid")
    public Categorie affichebyid(Long id) {
    	
    	
    	Categorie cat =this.categorieRep.findById(id).get();
    	return cat;
    }
    
    @PutMapping("archivercat")
    public String catArchiver(Long id ) {
    	
    	Categorie cat =this.categorieRep.findById(id).get();
cat.setStatus("Archiver");   
this.categorieRep.saveAndFlush(cat);
         return "categorie désarchivé avec succès";
    }
    
    
    @PutMapping("desarchiver")
    public String catdesArchiver(Long id ) {
       	
    	Categorie cat =this.categorieRep.findById(id).get();
cat.setStatus("desarchiver");   
this.categorieRep.saveAndFlush(cat);
         return "categorie désarchivé avec succès";
    }

@GetMapping("listarchiver")
public List<Categorie> listarchiver(){
	
	List<Categorie> cat=	this.categorieRep.findByStatus("Archiver");
	
	return cat;
}

@GetMapping("listdesarchiver")
public List<Categorie> listdesarchiver(){
	
	return this.categorieRep.findByStatus("desarchiver");
}


    
}
