package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.CategorieRepository;
import com.example.demo.entities.Categorie;

@RestController
public class CategorieController {

	@Autowired
	private CategorieRepository catRepo;
	
	//Ajouter Categorie
	@RequestMapping
	(value="/addCategorie", method=RequestMethod.POST)
	public Categorie addCategorie(@RequestBody Categorie cat) { 
		return catRepo.save(cat); }
	
	
	//Get un Categorie by id
	 @RequestMapping
	 (value="/getCategorie/{id}", method= RequestMethod.GET) 
	 public Categorie getCategorie(@PathVariable Long id){ 
		 return	 catRepo.findById(id).orElse(null); }
	 
	 //getCategories All
	 @RequestMapping
	 (value="/getCategorie", method= RequestMethod.GET) 
	 public List<Categorie> getCategorie(){ 
	 return catRepo.findAll(); }
	
	 //editCategorie  
	 @RequestMapping
	 (value="/editCategorie/{id}", method=RequestMethod.PUT)
	 public Categorie editCategorie(@PathVariable Long id, @RequestBody Categorie cat) { 
		 if(catRepo.findById(id).isPresent()) { cat.setId(id);
		 return catRepo.save(cat); }else { return cat; } }
	 
	 
     //Supprimer categorie
	 @RequestMapping("/deleteCategorie/{id}")
	 public String deleteCategorie (@PathVariable(value="id") Long id) { 
	 catRepo.deleteById(id); 
	 return "Supprimer avec succès="+id;  
	  }
	 
}
