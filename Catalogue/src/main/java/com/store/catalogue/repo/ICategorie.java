package com.store.catalogue.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.store.catalogue.entities.Categorie;

public interface ICategorie extends JpaRepository<Categorie, Long>{

	  List<Categorie> findByLibelle(String lib);
	  Page<Categorie> findByDescriptionLike(String desc, Pageable page);
	  Page<Categorie> findByLibelleOrDescription(String lib,String des,Pageable page );
	  
	  
}
