package com.project.Ebanking_BackEnd.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Ebanking_BackEnd.models.Agent;
import com.project.Ebanking_BackEnd.repository.AgentRepository;
@Service
public class AgentService implements IAgent{
	
	AgentRepository repo;
	 
    @Autowired
    public AgentService(AgentRepository repo)  {
        this.repo = repo;
    }
    @Override
    public List<Agent> getAllAgents() {
        // TODO Auto-generated method stub
   	 System.out.println(repo.findAll());
        return repo.findAll();
    }
    @Override
    public Optional<Agent> findById(int id) {
        // TODO Auto-generated method stub
        return repo.findById(id);
    }
    @Override
    public Optional<Agent> findByEmail(String email) {
        // TODO Auto-generated method stub
        return repo.findByEmail(email);
    }
    @Override
    public Agent save(Agent std) {
        // TODO Auto-generated method stub
        return repo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
   	 repo.deleteById(id);
    }

}
