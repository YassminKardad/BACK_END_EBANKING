package com.project.Ebanking_BackEnd.payload.response;

import java.util.List;

import com.project.Ebanking_BackEnd.models.Client;
import com.project.Ebanking_BackEnd.models.User;

public class JwtResponse {

		  private String token;
		  private String type = "Bearer";
		  private int id;
		  private String username;
		  private String email;
		  private List<String> roles;
		  private Client client;
		  
		  public JwtResponse(String accessToken, int id, String username, String email, Client client, List<String> roles) {
		    this.token = accessToken;
		    this.id = id;
		    this.username = username;
		    this.email = email;
		    this.roles = roles;
		    this.client  =  client;
		  }

		  public String getAccessToken() {
		    return token;
		  }

		  public void setAccessToken(String accessToken) {
		    this.token = accessToken;
		  }

		  public String getTokenType() {
		    return type;
		  }

		  public void setTokenType(String tokenType) {
		    this.type = tokenType;
		  }

		  public int getId() {
		    return id;
		  }

		  public void setId(int id) {
		    this.id = id;
		  }

		  public String getEmail() {
		    return email;
		  }

		  public void setEmail(String email) {
		    this.email = email;
		  }

		  public String getUsername() {
		    return username;
		  }

		  public void setUsername(String username) {
		    this.username = username;
		  }

		  public List<String> getRoles() {
		    return roles;
		  }
		
}
