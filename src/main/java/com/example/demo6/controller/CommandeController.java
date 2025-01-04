package com.example.demo6.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.entitie.Commande;
import com.example.demo6.repository.CommandeRepository;

@RestController
@RequestMapping("Commande")
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRep;

    @PostMapping("ajouter")
    public String addCommande(@RequestBody Commande commande) {
        commandeRep.save(commande);
        return "Commande ajoutée avec succès";
    }

    @GetMapping("afficher")
    public List<Commande> listCommandes() {
        return commandeRep.findAll();
    }

    @PutMapping("modifier/{id}")
    public String updatecommande( Long id, @RequestBody Commande cmd) {
      Commande commande = this.commandeRep.findById(id).get();
            
      commande.setDate(cmd.getDate());
      commande.setCodecmd(cmd.getCodecmd());
      commande.setAchats(cmd.getAchats());
       commandeRep.saveAndFlush(commande);
       return "Commande modifiée avec succès";
        }
    
    
    @GetMapping("Afficherbyid")
    public Commande affichebyid(Long id) {
    	
    	
    	Commande comm =this.commandeRep.findById(id).get();
    	return comm;
    }
    
    @PutMapping("archivercom")
    public String commArchiver(Long id ) {
    	
    	Commande commande =this.commandeRep.findById(id).get();
    	 commande.setStatus("Archiver");   
this.commandeRep.saveAndFlush(commande);
         return "Commande désarchivé avec succès";
    }
    
    
    @PutMapping("desarchiver")
    public String commdesArchiver(Long id ) {
       	
    	Commande comm =this.commandeRep.findById(id).get();
    	comm.setStatus("desarchiver");   
this.commandeRep.saveAndFlush(comm);
         return "Commande désarchivé avec succès";
    }

@GetMapping("listarchiver")
public List<Commande> listarchiver(){
	
	List<Commande> commande=	this.commandeRep.findByStatus("Archiver");
	
	return commande;
}

@GetMapping("listdesarchiver")
public List<Commande> listdesarchiver(){
	
	return this.commandeRep.findByStatus("desarchiver");
}
   
@DeleteMapping("Annulercommade")
public String annulercomm(Long id) {
	
this.commandeRep.deleteById(id);
return "commande supprime avec succes";
		
		
}

@GetMapping("afficherbydate")
public List<Commande> getCommandesByDate( Date date) {
    return commandeRep.findByDate(date);
}

@GetMapping("afficherbycode")
public List<Commande> getCommandesByCode( Integer codecmd) {
    return commandeRep.findByCodecmd(codecmd);
}


    }
