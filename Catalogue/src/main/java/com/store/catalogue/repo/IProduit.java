package com.store.catalogue.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.store.catalogue.entities.ProductDTO;
import com.store.catalogue.entities.Produit;

public interface IProduit extends JpaRepository<Produit, Long>{
	List<Produit> findByQuantiteLessThan(int seuil);
	Page<Produit> findByPrixBetween(double p1, double p2, Pageable page);
	List<ProductDTO> findByDesgLikeIgnoreCase(String d);
	
	
}
