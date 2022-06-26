package com.project.Ebanking_BackEnd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Ebanking_BackEnd.models.Agent;
import com.project.Ebanking_BackEnd.models.Client;
import com.project.Ebanking_BackEnd.models.User;
import com.project.Ebanking_BackEnd.repository.AgentRepository;
import com.project.Ebanking_BackEnd.repository.UserRepository;

@Service
public class UserService implements IUser{
	UserRepository repo;
	
	@Autowired
    public UserService(UserRepository repo)  {
        this.repo = repo;
    }
	@Override
    public User findById(int id) {
        // TODO Auto-generated method stub
        return repo.findById(id);
    }
	
	@Override
	public User findByPassword(String oldPassword) {
		// TODO Auto-generated method stub
		 return repo.findByPassword(oldPassword);
	}
	@Override
	public User findByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return repo.findByEmail(userEmail);
	}
	
	@Override
	public User findByClient(Client stdu) {
		// TODO Auto-generated method stub
		return repo.findByClient(stdu);
	}
	
	@Override
	public User findByAgent(Agent stdu) {
		// TODO Auto-generated method stub
		return repo.findByAgent(stdu);
	}
	

}
