package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  
@AllArgsConstructor  
@Entity
public class Utilisateur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	private String mail;
	private String password;
	private String role;

}
