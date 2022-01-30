package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  
@AllArgsConstructor  
@Entity
public class Client {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(length=1000)
	private String nom;
	@Column(length=1000)
	private String prenom;
	@Column(length=1000)
	private String adresse;
	@Column(length=1000)
	private String mail;
	@Column(length=1000)
	private String telephone;
	
	@OneToMany(mappedBy = "client") 
	 private List<Commande> commandes;
	 
	 @OneToMany(mappedBy = "client")
	 private List<Commentaire> commentaires;
	 
	

}
