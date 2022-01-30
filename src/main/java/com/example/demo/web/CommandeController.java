package com.example.demo.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.CommandeRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.Commande;

@RestController
public class CommandeController {

	@Autowired
	private CommandeRepository  comRepo;
	
	@Autowired
	private ClientRepository cliRepo;
	
//////////////**Ajouter Commande**********************//////////////
	
@RequestMapping
(value="/addCommande/{id}", method=RequestMethod.POST)
public Commande addCommande(@RequestBody Commande com ,@PathVariable Long id) { 
	
	 if(cliRepo.findById(id).isPresent()) {
		 Client c = new Client();
		 c= cliRepo.findById(id).get();
		 com.setClient(c);
		 
	 }return   comRepo.save(com); 
		 
	 }

//////////////////************Get commande by id**************///////////////
@RequestMapping
(value="/getCommande/{id}", method= RequestMethod.GET) 
public Commande getCommande(@PathVariable Long id){ 
	 return	 comRepo.findById(id).orElse(null); }

///////////////////////////********get All commandes **************///////////

@RequestMapping
(value="/getCommande", method= RequestMethod.GET) 
public List<Commande> getCommande(){ return comRepo.findAll(); }



//////////////////////////////*****editCategorie ***********************//////////////////////

@RequestMapping
(value="/editCommande/{id}", method=RequestMethod.PUT)
public Commande editCommande(@PathVariable Long id, @RequestBody Commande com) { 
	 if(comRepo.findById(id).isPresent()) { com.setId(id);
	 return comRepo.save(com); }else { return com; } }


//////////////////////////////////////////////Supprimer commande////////////////////////


@RequestMapping("/deleteCommande/{id}")

public String deleteCommande (@PathVariable(value="commandeId") Long id) 
{ comRepo.deleteById(id); return
"Supprimer avec succès="+id;

}


}
