package com.project.Ebanking_BackEnd.payload.response;
import java.util.List;

import com.project.Ebanking_BackEnd.models.Admin;
import com.project.Ebanking_BackEnd.models.Agent;
import com.project.Ebanking_BackEnd.models.Client;

public class UserInfoResponse {
	private int id;
	private List<String> roles;
	private Admin admin;
	private Client client;
	private Agent agent;


	public UserInfoResponse(int id, List<String> roles, Admin admin, Client client, Agent agent) {
		super();
		this.id = id;
		this.roles = roles;
		this.admin = admin;
		this.client = client;
		this.agent = agent;
	}


	public Admin getAdmin() {
		return admin;
	}



	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Agent getAgent() {
		return agent;
	}



	public void setAgent(Agent agent) {
		this.agent = agent;
	}



	public void setRoles(List<String> roles) {
		this.roles = roles;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public List<String> getRoles() {
		return roles;
	}
}
