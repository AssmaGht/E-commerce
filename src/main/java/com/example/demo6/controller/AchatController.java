package com.example.demo6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.entitie.Achat;
import com.example.demo6.repository.AchatRepository;

@RestController
@RequestMapping("achat")
public class AchatController {
	
	@Autowired
	private AchatRepository achatrep;
	  @PostMapping("ajouter")
	    public String addAchat(@RequestBody Achat achat) {
		  achatrep.save(achat);
	        return "achat ajoutée avec succès";
	    }
	  @GetMapping("afficher")
	    public List<Achat> listAchat() {
	        return achatrep.findAll();
	    }
	  
	  
	  @GetMapping("Afficherbyid")
	    public Achat affichebyid(Long id) {
	    	
	    	
	    	Achat ach =this.achatrep.findById(id).get();
	    	return ach;
	    }
	  
	  
	   
	  @DeleteMapping("Annulerachat")
	  public String annulerach(Long id) {
	  	
	  this.achatrep.deleteById(id);
	  return "achat supprime avec succes";		
	  }
	  
	    @GetMapping("affichercommandebyId")
	    public List<Achat> getAchatsByCommande( Long commandeId) {
	        return this.achatrep.findByCommandeId(commandeId);
	    }

	    @GetMapping("afficherarticleId")
	    public List<Achat> getAchatsByArticle( Long articleId) {
	        return this.achatrep.findByArticleId(articleId);
	    }

	    @GetMapping("affichenbachat")
	    public Long countAchats() {
	        return this.achatrep.count();
	    }

}
