package com.project.Ebanking_BackEnd.services;

import java.util.Optional;

import com.project.Ebanking_BackEnd.models.Agent;
import com.project.Ebanking_BackEnd.models.Client;
import com.project.Ebanking_BackEnd.models.User;

public interface IUser {

	User findById(int id);

	User findByPassword(String password);

	User findByEmail(String email);

	User findByClient(Client stdu);

	User findByAgent(Agent stdu);

}
