package com.project.Ebanking_BackEnd.models;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Admin")
//@DiscriminatorValue("1")
public class Admin extends Profil {
	
	public Admin(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@NotBlank @Size(max = 30) String phone, @NotBlank @Size(max = 30) String address,
			java.util.Date dateOfBirth, @Email String email, @NotBlank @Size(max = 120) String confirmationEmail) {
		super(firstname, lastname, phone, address, dateOfBirth, email, confirmationEmail);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}	
