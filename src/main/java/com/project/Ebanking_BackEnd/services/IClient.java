package com.project.Ebanking_BackEnd.services;

import java.util.List;
import java.util.Optional;

import com.project.Ebanking_BackEnd.models.Client;

public interface IClient {


	List<Client> getAllClients();
    Optional<Client> findById(int id);
    Optional<Client> findByEmail(String email);
    Client save(Client std);
    void deleteById(int id);
    
}
