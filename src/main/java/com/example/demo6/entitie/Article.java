package com.example.demo6.entitie;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;
    
    private float prix; 

    private int qte;

    private Date dateajout;

    private String stockstatus ; 
    
    private String codepromo ; 

 
    
    @ManyToOne
    private Utilisateur user;
}
