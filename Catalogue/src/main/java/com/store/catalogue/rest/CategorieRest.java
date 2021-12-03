package com.store.catalogue.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.catalogue.entities.Categorie;
import com.store.catalogue.entities.ProductDTO;
import com.store.catalogue.entities.Produit;
import com.store.catalogue.repo.ICategorie;
import com.store.catalogue.repo.IProduit;

@RestController
public class CategorieRest {
	@Autowired
	ICategorie catrepo;
	@Autowired
	IProduit prepo;
	
	@GetMapping("/categories")
	public List<Categorie> all()
	{
		return catrepo.findAll();
	}
	
	@PostMapping("/categories")
	public Categorie addcat(@RequestBody Categorie c)
	{
		return catrepo.save(c);
	}
	
	@GetMapping("/categories/{id}")
	public Categorie addcat(@PathVariable long id)
	{
		return catrepo.findById(id).get();
	}
	
	@GetMapping("/categories/search")
	public Page<Categorie> serach(@RequestParam(name = "q") String q,@RequestParam(name="page") int page)
	{
		 Pageable p=PageRequest.of(page, 10);
		return catrepo.findByDescriptionLike(q, p);
		
	}
	
	@PostMapping("categories/{idcat}/produits")
	public Produit addprod(@RequestBody Produit p,@PathVariable(name="idcat") long idcat)
	{
		Categorie cat = catrepo.findById(idcat).get();
		p.setCategorie(cat);
		p=prepo.save(p);
		return p;
	}
	
	@GetMapping("categories/{idcat}/produits")
	public List<Produit> allprd(@PathVariable (name="idcat")long idcat)
	{
		Categorie c = catrepo.findById(idcat).get();
		return c.getProduits();
		 
	} 
	
	@GetMapping("categories/{idcat}/products")
	public List<Produit> allprduct(@PathVariable (name="idcat")long idcat)
	{
		return prepo.findByCategorieId(idcat);		 
	} 
	
	@GetMapping("categories/produits/search")
	public List<ProductDTO> allprd(String q)
	{
		List<ProductDTO> ps = prepo.findByDesgLikeIgnoreCase(q);
		return ps;
	} 
	
}
