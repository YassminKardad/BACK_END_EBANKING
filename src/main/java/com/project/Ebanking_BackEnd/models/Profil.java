package com.project.Ebanking_BackEnd.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "profil",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "email")
       })
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class  Profil {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	/*
	 * Commons Attributes
	 */
	@NotBlank
	@Size(max = 30)
	protected String firstname;

	@NotBlank
	@Size(max = 30)
	protected String lastname;

	@NotBlank
	@Size(max = 30)
	protected String phone;

	@NotBlank
	@Size(max = 30)
	protected String address;
	protected Date dateOfBirth;
	
	 @Email
	protected String email;
	 

	 @NotBlank
	 @Size(max = 120)
	 protected String confirmationEmail;


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getConfirmationEmail() {
		return confirmationEmail;
	}


	public void setConfirmationEmail(String confirmationEmail) {
		this.confirmationEmail = confirmationEmail;
	}


	public Profil(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@NotBlank @Size(max = 30) String phone, @NotBlank @Size(max = 30) String address, Date dateOfBirth,
			@Email String email, @NotBlank @Size(max = 120) String confirmationEmail) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.confirmationEmail = confirmationEmail;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 

}
