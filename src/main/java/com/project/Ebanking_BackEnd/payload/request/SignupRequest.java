package com.project.Ebanking_BackEnd.payload.request;
import java.sql.Date;
import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    
    @NotBlank
    @Size(min = 3, max = 30)
    private String firstname,lastname;
    
    CharSequence password;
    
    private String phone,ConfirmationEmail,address;
    private Date DateOfBirth;
    
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getConfirmationEmail() {
		return ConfirmationEmail;
	}

	public void setConfirmationEmail(String confirmationEmail) {
		ConfirmationEmail = confirmationEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public CharSequence getPassword() {
		return password;
	}

	public void setPassword(CharSequence password) {
		this.password = password;
	}


    private Set<String> role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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


	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public SignupRequest(@NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(min = 3, max = 30) String firstname, @NotBlank @Size(min = 3, max = 30) String lastname,
			CharSequence password, String phone, String confirmationEmail, String address, Date dateOfBirth
			) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.phone = phone;
		ConfirmationEmail = confirmationEmail;
		this.address = address;
		DateOfBirth = dateOfBirth;
	}
    
    
  
   
}
