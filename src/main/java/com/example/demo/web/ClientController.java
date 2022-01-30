package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entities.Client;

@RestController
public class ClientController {

	@Autowired
	private ClientRepository cliRepo;

	//@Autowired
	//private CommandeRepository commandeRepo;
	
	
	 //Get un client	  
	 @GetMapping("/getClient/{id}") 
	 public Client getClient(@PathVariable Long id){ 
	 return cliRepo.findById(id).orElse(null); }
	  
	  //Get les clients
	  @GetMapping("/getClients") 
	  public List<Client> getClients(){  
	  return cliRepo.findAll(); }
	  
	  //Subscribe client
	  @PostMapping("/subscribeClient") 
	  public Client subscribeClient(@RequestBody Client c) { 
	  return cliRepo.save(c); }
	  
	  //Rechercher client par mot clé  
	  @GetMapping("/searchClient/{motCle}") 
	  public List<Client> searchClient(@PathVariable String motCle){ 
	  return cliRepo.findByNomContains(motCle); }
	 
	  //Get commande par Id client
	//  @GetMapping("/getCommandeClientId/{idClient}") 
	//  public List<Commande> getCommande(@PathVariable Long idClient){ 
		//  return commandeRepo.findByClientId(idClient).orElse(null); }
 


}
