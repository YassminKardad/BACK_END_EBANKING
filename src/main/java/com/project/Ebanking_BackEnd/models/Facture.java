package com.project.Ebanking_BackEnd.models;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Enumerated(EnumType.STRING)
	private TypeCreancier Creancier;
	private String Tel;
	private Double Montant;
	//private String type;
	private Date date;
	private Boolean Is_Payed;
	private String Address;
	private String NumCompteur;
	@ManyToOne
    @JoinColumn(name="client_id")
	private Client client;
	
	
	public Boolean getIs_Payed() {
		return Is_Payed;
	}
	public void setIs_Payed(Boolean is_Payed) {
		Is_Payed = is_Payed;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public TypeCreancier getCreancier() {
		return Creancier;
	}
	public void setCreancier(TypeCreancier creancier) {
		Creancier = creancier;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public Double getMontant() {
		return Montant;
	}
	public void setMontant(Double montant) {
		Montant = montant;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getStatus() {
		return Is_Payed;
	}
	public void setStatus(Boolean status) {
		Is_Payed = status;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getNumCompteur() {
		return NumCompteur;
	}
	public void setNumCompteur(String numCompteur) {
		NumCompteur = numCompteur;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Facture(TypeCreancier creancier, String tel, Double montant, String type, Date date, Boolean status,
			String address, String numCompteur, Client client) {
		super();
		Creancier = creancier;
		Tel = tel;
		Montant = montant;
		this.date = date;
		Is_Payed = status;
		Address = address;
		NumCompteur = numCompteur;
		this.client = client;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static int generateCode() {
		Random rand = new Random();
		int randomNum = rand.nextInt((99999 - 10000) + 1) + 10000;
		System.out.println(randomNum);
		return randomNum;

	}
	
	
	

}
