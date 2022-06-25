package com.project.Ebanking_BackEnd.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import com.project.Ebanking_BackEnd.repository.AccountStatus;

import java.util.Date;
import java.util.List;
@Entity
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)*/
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Compte {
    @Id
    private int id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @OneToOne
    private Client customer;

    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
    private List<AccountOperation> accountOperations;

    
    
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public Compte(int id, double balance, Date createdAt, AccountStatus status, Client customer,
			List<AccountOperation> accountOperations) {
		super();
		this.id = id;
		this.balance = balance;
		this.createdAt = createdAt;
		this.status = status;
		this.customer = customer;
		this.accountOperations = accountOperations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public Client getCustomer() {
		return customer;
	}

	public void setCustomer(Client customer) {
		this.customer = customer;
	}

	public List<AccountOperation> getAccountOperations() {
		return accountOperations;
	}

	public void setAccountOperations(List<AccountOperation> accountOperations) {
		this.accountOperations = accountOperations;
	}
    
}
