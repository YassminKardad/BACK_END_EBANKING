package com.project.Ebanking_BackEnd.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Ebanking_BackEnd.models.Compte;
import com.project.Ebanking_BackEnd.models.Facture;
import com.project.Ebanking_BackEnd.repository.FactureRepo;
import com.project.Ebanking_BackEnd.repository.UserRepository;
import com.project.Ebanking_BackEnd.services.sms.SmsRequest;

@Service
public class FactureService {
	
	@Autowired
	FactureRepo repo;
	
	@Autowired
	AccountService serv;
	
	public List<Facture> find(int id) {
        return repo.find(id);
    }
	
	public Facture findById(int Id)
	{
		return repo.findById(Id);
	}
	
	public int update(int id,int factId) {
		Compte compte=serv.find(id);
		Double balance =compte.getBalance();
		Facture facture = repo.findById(factId);
		Double montant=facture.getMontant();
		System.out.println(compte.getBalance()+ "   "+ facture.getMontant()+"  "+facture.getIs_Payed());
		int random = Facture.generateCode();
		
		if(balance>montant)
		{
			balance -= montant ;
			System.out.println("hhs: "+balance+ "   "+ montant+"  ");
			compte.setBalance(balance);
			facture.setIs_Payed(true);
	        repo.update(id,factId);
			System.out.println(compte.getBalance()+ "   "+ facture.getMontant()+"  "+facture.getIs_Payed());
			
			return 1;

		}
		
		else {
			return 0;
		}

	}
	
	public int checkSolde(int id,int factId) {
		Compte compte=serv.find(id);
		Double balance =compte.getBalance();
		Facture facture = repo.findById(factId);
		Double montant=facture.getMontant();
		System.out.println(compte.getBalance()+ "  and "+ facture.getMontant()+"  "+facture.getIs_Payed());
		
		if(balance>montant)
		{
			
			return 1;
		}
		
		else {
			return 0;
		}

	}

	public void validPay(int id,int factId) {
		Compte compte=serv.find(id);
		Double balance =compte.getBalance();
		Facture facture = repo.findById(factId);
		Double montant=facture.getMontant();
		balance -= montant ;
		System.out.println("New balance: "+balance);
		compte.setBalance(balance);
		facture.setIs_Payed(true);
        repo.update(id,factId);
		System.out.println(compte.getBalance()+ "   "+ facture.getMontant()+"  "+facture.getIs_Payed());		
	}
	
	
}
