package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Oeuvre;

@CrossOrigin("*")
@RestController
public interface OeuvreRepository extends JpaRepository<Oeuvre, Long>{
	//méthode findByNomProduitContains TESTEE = OK
		@RestResource (path = "/ByNom")
		public List<Oeuvre> findByNomContains(@Param("name") String nom);

}
