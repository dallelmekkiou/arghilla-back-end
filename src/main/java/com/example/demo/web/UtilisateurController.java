package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.UtilisateurRepository;
import com.example.demo.entities.Utilisateur;

@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurRepository uRepo;
	
	 //Get un Utilisateur	  
	 @GetMapping("/get/{id}") 
	 public Utilisateur getUtilisateur(@PathVariable Long id){ 
	 return uRepo.findById(id).orElse(null); }
	  
	  //Get les Utilisateurs
	  @GetMapping("/getUtilisateurs") 
	  public List<Utilisateur> getUtilisateurs(){  
	  return uRepo.findAll(); }
	  
	  //Subscribe Utilisateur
	  @PostMapping("/subscribeUtilisateur") 
	  public Utilisateur subscribeUtilisateur(@RequestBody Utilisateur u) { 
	  return uRepo.save(u); }
	  
	  //Rechercher Utilisateur par mot clé  
	  @GetMapping("/searchUtilisateur/{motCle}") 
	  public List<Utilisateur> searchUtilisateur(@PathVariable String motCle){ 
	  return uRepo.findByMailContains(motCle); }
	 
}
