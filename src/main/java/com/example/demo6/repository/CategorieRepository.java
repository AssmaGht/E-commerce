package com.example.demo6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo6.entitie.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

	List<Categorie> findByStatus(String string);

}
