package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Utilisateur;

@CrossOrigin("*")
@RestController
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	@RestResource(path="/byMail") 
	public List<Utilisateur>findByMailContains(@Param("mail")String mail);	 
	

}
