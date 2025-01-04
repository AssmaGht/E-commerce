package com.example.demo6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.entitie.Utilisateur;
import com.example.demo6.repository.UtilisateurRepository;

@RestController
@RequestMapping("utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurRepository userrepo;
	
	
	@PostMapping("Ajouter")
	 public String Addarticle(@RequestBody Utilisateur user) {
        this.userrepo.save(user);
        return "user ajouté avec succès";
    } 
	


    @PutMapping("modifier")
    public String updateUtilisateur( Long id, @RequestBody Utilisateur u) {
        Utilisateur utilisateur = this.userrepo.findById(id).get();
      
        utilisateur.setNom(u.getNom());
        utilisateur.setPrenom(u.getPrenom());
        utilisateur.setEmail(u.getEmail());
        utilisateur.setMotDePasse(u.getMotDePasse());
         this.userrepo.saveAndFlush(utilisateur);
        return "user modifie avec succès";
    }
    
    @GetMapping("afficher")
public List<Utilisateur> listUtilisateurs() {
    return this.userrepo.findAll();
}
    @GetMapping("afficherbyid")
public Utilisateur listtUtilisateurs(Long id) {
    Utilisateur u =this.userrepo.findById(id).get();
    return u;
}
    
    
    @PutMapping("archiver")
    public String Archiver(Long id ) {
    	
    	Utilisateur user =this.userrepo.findById(id).get();
    	
    	user.setSatuts(true);
    	this.userrepo.saveAndFlush(user);
    	return "user archive avec succès";
    }
    
    
    @PutMapping("desarchiver")
    public String desArchiver(Long id ) {
    	
    	Utilisateur user =this.userrepo.findById(id).get();
    	
    	user.setSatuts(false);
    	this.userrepo.saveAndFlush(user);
    	return "user desarchive avec succès";
    }
    
    
    @GetMapping("listarchive")
    public List<Utilisateur> listarchiver()
    {
     
    return this.userrepo.findBysatuts(true);	
    }
    
    
    @GetMapping("listnonarchive")
    public List<Utilisateur> listnonarchiver()
    {
     
    return this.userrepo.findBysatuts(false);	
    }
}

