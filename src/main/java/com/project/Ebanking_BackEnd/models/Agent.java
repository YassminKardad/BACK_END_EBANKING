package com.project.Ebanking_BackEnd.models;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "Agent")
@NoArgsConstructor
//@DiscriminatorValue("2")
public class Agent extends Profil {
	  private String pieceIdentity;
	  private String n_pieceIdentity;
	  private double n_Immatr;
      private double n_Pattente;
      private String pieceJointe;
      
      public Agent() {
    	  super();
  		// TODO Auto-generated constructor stub
  	}
 
      
 

	public Agent(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@NotBlank @Size(max = 30) String phone, @NotBlank @Size(max = 30) String address,
			java.util.Date dateOfBirth, @Email String email, @NotBlank @Size(max = 120) String confirmationEmail) {
		super(firstname, lastname, phone, address, dateOfBirth, email, confirmationEmail);
		// TODO Auto-generated constructor stub
	}



	public Agent(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@NotBlank @Size(max = 30) String phone, @NotBlank @Size(max = 30) String address,
			java.util.Date dateOfBirth, @Email String email, @NotBlank @Size(max = 120) String confirmationEmail,
			String pieceIdentity, String n_pieceIdentity, double n_Immatr, double n_Pattente, String pieceJointe) {
		super(firstname, lastname, phone, address, dateOfBirth, email, confirmationEmail);
		this.pieceIdentity = pieceIdentity;
		this.n_pieceIdentity = n_pieceIdentity;
		this.n_Immatr = n_Immatr;
		this.n_Pattente = n_Pattente;
		this.pieceJointe = pieceJointe;
	}



	public String getPieceIdentity() {
		return pieceIdentity;
	}


	public void setPieceIdentity(String pieceIdentity) {
		this.pieceIdentity = pieceIdentity;
	}


	public String getN_pieceIdentity() {
		return n_pieceIdentity;
	}


	public void setN_pieceIdentity(String n_pieceIdentity) {
		this.n_pieceIdentity = n_pieceIdentity;
	}


	public double getN_Immatr() {
		return n_Immatr;
	}


	public void setN_Immatr(double n_Immatr) {
		this.n_Immatr = n_Immatr;
	}


	public double getN_Pattente() {
		return n_Pattente;
	}


	public void setN_Pattente(double n_Pattente) {
		this.n_Pattente = n_Pattente;
	}


	public String getPieceJointe() {
		return pieceJointe;
	}


	public void setPieceJointe(String pieceJointe) {
		this.pieceJointe = pieceJointe;
	}
      
      
      
}
