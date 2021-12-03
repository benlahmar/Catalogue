package com.store.catalogue.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.catalogue.entities.ProductDTO;
import com.store.catalogue.repo.IProduit;

@RestController
public class ProduitRest {

	@Autowired
	IProduit prepo;
	@GetMapping("/produits/search")
	public List<ProductDTO> alldto(@RequestParam(name = "q") String d)
	{
		return prepo.findByDesgLikeIgnoreCase(d);
		
	}
}
