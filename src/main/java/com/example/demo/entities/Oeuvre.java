package com.example.demo.entities;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  
@AllArgsConstructor  
@Entity
public class Oeuvre {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(length=1000)
	private String nom;
	@Column(length=1000)
	private String description;
	@Column(length=1000)
	private String image;
	private double prix;
	private int quantite;
	private boolean disponibilite;
	
	@ManyToOne
	private Categorie categorie;
	@ManyToMany 
	private List<Commande> commandes;
	@OneToMany(mappedBy = "oeuvre")
	private List<Commentaire> commentaires;
	
}
