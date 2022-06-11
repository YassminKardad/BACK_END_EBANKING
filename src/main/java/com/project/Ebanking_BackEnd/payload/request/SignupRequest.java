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
    
    
  
   
}
