package com.project.Ebanking_BackEnd.services;

import java.util.List;
import java.util.Optional;

import com.project.Ebanking_BackEnd.models.Agent;
import com.project.Ebanking_BackEnd.models.User;


public interface IAgent {
	List<Agent> getAllAgents();
    Optional<Agent> findById(int id);
    Optional<Agent> findByEmail(String email);
    Agent save(Agent std);
    void deleteById(int id);

}
