package com.example.demo6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo6.entitie.Achat;

public interface AchatRepository extends JpaRepository<Achat, Long>{

	List<Achat> findByCommandeId(Long commandeId);

	List<Achat> findByArticleId(Long articleId);


}
