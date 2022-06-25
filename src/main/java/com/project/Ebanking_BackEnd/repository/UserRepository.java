package com.project.Ebanking_BackEnd.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ebanking_BackEnd.models.Agent;
import com.project.Ebanking_BackEnd.models.Client;
import com.project.Ebanking_BackEnd.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  //Optional<User> findByUsername(String username);
  Optional<User> findByEmail(String mail);
  //Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
  User findById(int id);
  User findByPassword(String password);

  User findByClient(Client stdu);

  User findByAgent(Agent stdu);
 
}
