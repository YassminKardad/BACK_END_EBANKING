package com.project.Ebanking_BackEnd.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.InheritanceType;



@Entity
@Table(name = "users")
/*@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="discriminator", discriminatorType = DiscriminatorType.INTEGER )
@DiscriminatorValue("0")*/
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User {

	private static final long serialVersionUID = 1L;

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	/*
	 * Commons Attributes
	 */
	@NotBlank
	@Size(max = 30)
	protected String firstname;

	@NotBlank
	@Size(max = 30)
	protected String lastname;

	/*@NotBlank
	@Size(max = 30)
	protected String phone;*/

	/*@NotBlank
	@Size(max = 30)
	protected String address;*/
	//protected Date dateOfBirth;
	protected Boolean has_Already_loggedIn;
	
	 @Email
	protected String email;
	 
	 //@Column(name="passwordGenerated")
	 protected String password;

	/*@NotBlank
	 @Size(max = 120)*/
	 //protected String confirmationEmail;
	
      @ManyToMany(fetch = FetchType.LAZY)
      @JoinTable(name = "user_roles", 
                 joinColumns = @JoinColumn(name = "user_id"),
                 inverseJoinColumns = @JoinColumn(name = "role_id"))
	protected Set<Role> roles = new HashSet<>();

     @OneToOne
     @JoinColumn(name="agent_id")
     protected Agent agent;
     @OneToOne
     @JoinColumn(name="client_id")
     protected Client client;
     @OneToOne
     @JoinColumn(name="admin_id")
     protected Admin admin;

      
      
	
	/*
	 * Constructer for Agent
	 */
	/*public User(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@NotBlank @Size(max = 30) String phone, @NotBlank @Size(max = 30) String confirmationEmail,
			@NotBlank @Size(max = 30) String address, Date dateOfBirth,
			@Email String email ,String pieceIdentity,
			String n_pieceIdentity, double n_Immatr, double n_Pattente, String pieceJointe,String pass) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.confirmationEmail = confirmationEmail;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.has_Already_loggedIn = false;
		this.email = email;
		this.pieceIdentity = pieceIdentity;
		this.n_pieceIdentity = n_pieceIdentity;
		this.n_Immatr = n_Immatr;
		this.n_Pattente = n_Pattente;
		this.pieceJointe = pieceJointe;
		this.password=pass;
		System.out.println(this.password);
		Role role = new Role(ERole.ROLE_AGENT);
		this.roles.add(role);
	}*/

	/*
	 * Constructer for Admin Only ------ JUST TO TEST SIGNUP
	 */
	
	public User(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@Email String email,String pass) {
		
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.has_Already_loggedIn = false;
		this.email = email;
		this.password=pass;
		System.out.println(this.password);
		/*Role role = new Role(ERole.ROLE_ADMIN);
		this.roles.add(role);*/	
		}
	
	
	/*
	 * Constructer for Client
	 */
	/*public User(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@NotBlank @Size(max = 30) String phone, @NotBlank @Size(max = 30) String confirmationEmail,
			@NotBlank @Size(max = 30) String address, Date dateOfBirth,
			@Email String email, String pieceIdentity,
			String n_pieceIdentity,String pass) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.confirmationEmail = confirmationEmail;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.has_Already_loggedIn = false;
		this.email = email;
		this.pieceIdentity = pieceIdentity;
		this.n_pieceIdentity = n_pieceIdentity;
		this.password=pass;
		System.out.println(this.password);
		Role role = new Role(ERole.ROLE_CLIENT);
		this.roles.add(role);
	}*/
	
	//for Client
	public User(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@Email String email, String password,Client client) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.client=client;
		this.has_Already_loggedIn = false;
		Role role = new Role(ERole.ROLE_CLIENT);
		this.roles.add(role);
	}
	
	//for Client
	public User(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@Email String email, String password,Agent agent) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.agent=agent;
		this.has_Already_loggedIn = false;
		Role role = new Role(ERole.ROLE_AGENT);
		this.roles.add(role);
	}

	


	public User(int id, @NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname,
			@Email String email, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}


	public User(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname, @Email String email, String password, Set<Role> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}



	


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public void setHas_Already_loggedIn(Boolean has_Already_loggedIn) {
		this.has_Already_loggedIn = has_Already_loggedIn;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
      
	public Boolean getHas_Already_loggedIn() {
		return has_Already_loggedIn;
	}
	
	
	public static char[] generatePassword() {
		
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[6];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));
     
        for(int i = 4; i< 6 ; i++) {
           password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        
        System.out.println("in fct  "+password);
        return password;
     }


	/*
	public static String generatePassword() {
		StringBuilder token = new StringBuilder();

		return token.append(UUID.randomUUID().toString())
				.append(UUID.randomUUID().toString()).toString();
	}
*/
      
}

