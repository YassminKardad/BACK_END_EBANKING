package com.project.Ebanking_BackEnd.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Ebanking_BackEnd.models.Client;
import com.project.Ebanking_BackEnd.models.User;
import com.project.Ebanking_BackEnd.repository.ClientRepository;



@Service
public class ClientService implements IClient{
	
	ClientRepository repo;
	
    @Autowired
    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }
	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		System.out.println(repo.findAll());
        return repo.findAll();
	}

	@Override
	public Optional<Client> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Optional<Client> findByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}

	@Override
	public Client save(Client std) {
		// TODO Auto-generated method stub
		return repo.save(std);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}



}
