package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  
@AllArgsConstructor  
@Entity
public class Commentaire {

	 @Id
  	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 private String commentaire;
	 private String date;
	 
	 @OneToOne
	 private Oeuvre oeuvre;
	 
	 @OneToOne
	 private Client client;
	 
}
