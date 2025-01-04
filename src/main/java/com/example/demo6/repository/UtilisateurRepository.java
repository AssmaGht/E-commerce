package com.example.demo6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo6.entitie.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	Utilisateur findByNom(Utilisateur u);


	List<Utilisateur> findBysatuts(boolean b);

}
