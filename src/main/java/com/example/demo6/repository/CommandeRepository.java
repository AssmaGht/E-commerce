package com.example.demo6.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo6.entitie.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

	List<Commande> findByStatus(String string);

	List<Commande> findByDate(Date date);

	List<Commande> findByCodecmd(Integer codecmd);


}
