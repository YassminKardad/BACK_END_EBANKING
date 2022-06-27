package com.project.Ebanking_BackEnd.security.services;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Ebanking_BackEnd.models.Admin;
import com.project.Ebanking_BackEnd.models.Agent;
import com.project.Ebanking_BackEnd.models.Client;
import com.project.Ebanking_BackEnd.models.Role;
import com.project.Ebanking_BackEnd.models.User;

public class UserDetailsImpl implements UserDetails {
	  private static final long serialVersionUID = 1L;

	  private int id;

	  private String firstname,lastname,email;

	  private User user;
	  
	  public UserDetailsImpl(User user) {
	      this.user = user;
	  }

	  public String getFirstName() {
	      return this.user.getFirstname();
	  }
	  
	  

	  public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	@JsonIgnore
	  private CharSequence password;

	  private Collection<? extends GrantedAuthority> authorities;

	  public UserDetailsImpl(int id, String firstname, String lastname,String email,CharSequence pass, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = pass;
		this.authorities = authorities;
	}



	  public static UserDetailsImpl build(User user) {
	    List<GrantedAuthority> authorities = user.getRoles().stream()
	        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
	        .collect(Collectors.toList());

	    return new UserDetailsImpl(
	        user.getId(), 
	        user.getFirstname(),user.getLastname(),
	        user.getEmail(),
	        user.getPassword(), 
	        authorities);
	  }
	  
	  
	  
	  
	  /*public static User build(UserDetailsImpl user) {
		    List<GrantedAuthority> authorities = user.getAuthorities().stream()
		        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
		        .collect(Collectors.toList());

		    return new User(
		        user.getId(), 
		        user.getFirstname(),user.getLastname(),
		        user.getEmail(),
		        user.getPassword(), 
		        authorities);
		  }*/
	  
	  

	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return authorities;
	  }

	 

	  public int getId() {
		return id;
	}



	public String getFirstname() {
		return firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public String getEmail() {
		return email;
	}





	@Override
	public String getPassword() {
		return (String) password;
	}

	public String getName() {
		return (String) this.firstname+" "+this.lastname;
	}

	public Client getClientId() {
		return this.getUser().getClient();
	}


	@Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    UserDetailsImpl user = (UserDetailsImpl) o;
	    return Objects.equals(id, user.id);
	  }



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}


	}