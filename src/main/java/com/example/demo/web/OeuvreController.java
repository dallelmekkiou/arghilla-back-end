package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CategorieRepository;
import com.example.demo.dao.OeuvreRepository;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Oeuvre;

@RestController
public class OeuvreController {
	@Autowired
	private  OeuvreRepository oeuvreRepo;
	@Autowired
	private  CategorieRepository catRepo;
	
	
//CRUD: CREATE = ADD - insertion d'un oeuvre avec categorieId TESTEE = OK	
	@RequestMapping
	(value="/addOeuvre/{id}", method=RequestMethod.POST)
	public Oeuvre addOeuvre(@RequestBody Oeuvre oeuvre ,@PathVariable Long id) { 

	     if(catRepo.findById(id).isPresent()) {
	         Categorie c = new Categorie();
	         c= catRepo.findById(id).get();
	         oeuvre.setCategorie(c);
	     }
	     return   oeuvreRepo.save(oeuvre); 
	     }

		
//CRUD: READ = GET - récuperation d' un seul oeuvre TESTEE = OK
		@RequestMapping(value="/getOeuvre/{id}", method = RequestMethod.GET)
		@ResponseBody
		public Oeuvre getOeuvre (@PathVariable("id") Long id) {
		return  oeuvreRepo.findById(id).orElse(null);
		}	
		
//CRUD: READ = GET - récuperation plusieurs oeuvres TESTEE = OK
		@RequestMapping(value="/getOeuvres", method = RequestMethod.GET)
		@ResponseBody
		public List<Oeuvre> getOeuvres(){
		return oeuvreRepo.findAll();
		}
		
//CRUD: UPDATE = EDIT - modification =  "put" TESTEE = OK
		@RequestMapping(value="/editOeuvre/{id}", method = RequestMethod.PUT)
				
		public Oeuvre editOeuvre(@PathVariable Long id,@RequestBody Oeuvre oeuvre) {
		System.out.println(id);
				
		oeuvre.setId(id);                    
		return oeuvreRepo.save(oeuvre);
		}
		
//CRUD: DELETE = DELETE - suppression de plusieurs oeuvres TESTEE = OK
		@RequestMapping(value="/deleteOeuvres", method = RequestMethod.DELETE)
		@ResponseBody
	    public  boolean  deleteOeuvres(){
	    oeuvreRepo.deleteAll();
		return true;
		}

//CRUD: DELETE = DELETE - suppression d'un seul oeuvre TESTEE = 
		@RequestMapping(value="/deleteOeuvre/{id}", method = RequestMethod.DELETE)
		@ResponseBody
		public boolean deleteOeuvre (@PathVariable Long id) {
		oeuvreRepo.deleteById(id);
		return true;	
		}
	
}
