package com.project.Ebanking_BackEnd.controllers;

import java.awt.print.Pageable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Ebanking_BackEnd.exceptions.AgentNotFoundException;
import com.project.Ebanking_BackEnd.exceptions.BalanceNotSufficientException;
import com.project.Ebanking_BackEnd.exceptions.BankAccountNotFoundException;
import com.project.Ebanking_BackEnd.models.AccountOperation;
import com.project.Ebanking_BackEnd.models.Client;
import com.project.Ebanking_BackEnd.models.Compte;
import com.project.Ebanking_BackEnd.models.ERole;
import com.project.Ebanking_BackEnd.models.Facture;
import com.project.Ebanking_BackEnd.models.Role;
import com.project.Ebanking_BackEnd.models.User;
import com.project.Ebanking_BackEnd.payload.request.AddClientRequest;
import com.project.Ebanking_BackEnd.payload.request.SignupRequest;
import com.project.Ebanking_BackEnd.payload.response.MessageResponse;
import com.project.Ebanking_BackEnd.repository.AccountOperationRepository;
import com.project.Ebanking_BackEnd.repository.BankAccountRepository;
import com.project.Ebanking_BackEnd.repository.ClientRepository;
import com.project.Ebanking_BackEnd.repository.OperationType;
import com.project.Ebanking_BackEnd.repository.RoleRepository;
import com.project.Ebanking_BackEnd.repository.UserRepository;
import com.project.Ebanking_BackEnd.security.services.UserDetailsImpl;
import com.project.Ebanking_BackEnd.services.ClientOperationsService;
import com.project.Ebanking_BackEnd.services.ClientService;
import com.project.Ebanking_BackEnd.services.EmailServiceImp;
import com.project.Ebanking_BackEnd.services.FactureService;
import com.project.Ebanking_BackEnd.services.UserService;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins= "http://localhost:4200/")
public class ClientController {
	@Autowired
    private BankAccountRepository bankAccountRepository;
	@Autowired
    AccountOperationRepository accountOperationRepository;
	@Autowired
    ClientService serv;
	@Autowired
	ClientOperationsService clietOpServ;
	 @Autowired
	  UserRepository userRepository;
	 
	  @Autowired
	  ClientRepository repo;

	  @Autowired
	  RoleRepository roleRepository;

	  @Autowired
	  PasswordEncoder encoder;
	  
	  @Autowired
	  EmailServiceImp emailService;
	  
	  @Autowired
		 UserService user_serv;
	  @Autowired
	  FactureService fact_serv;
	  
    @Autowired
    public ClientController(ClientService serv) {
        this.serv = serv;
    }
    
    @GetMapping(value="/clients")
    public List<Client> getAllClients(){
        return serv.getAllClients();
    }           
    @GetMapping(value="/clients/{id}")
    public Client getClientById(@PathVariable("id") @Min(1) int id) {
   	 Client std = serv.findById(id)
                                    .orElseThrow(()->new AgentNotFoundException("Client with "+id+" is Not Found!"));
        return std;
    } 
    @PostMapping("/addClient")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AddClientRequest signUpRequest) {
      /*if (userRepository.existsByUsername(signUpRequest.getUsername())) {
        return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
      }*/

      if (repo.existsByEmail(signUpRequest.getEmail())) {
        return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
      }

      // Create new user's account
     
      
      //Generate password 
      char[] password= User.generatePassword();
      //System.out.println("generated password is :  "+password.toString());
      
      System.out.println(password);
      //System.out.println(java.nio.CharBuffer.wrap(password));
      System.out.println(String.valueOf(password));
      
     Client user1 = new Client(signUpRequest.getFirstname(),signUpRequest.getLastname(),signUpRequest.getPhone(),signUpRequest.getAddress(),signUpRequest.getDateOfBirth(),
                           signUpRequest.getEmail(),signUpRequest.getConfirmationEmail(),signUpRequest.getPieceIdentity(),signUpRequest.getN_pieceIdentity()
                         );
     
     repo.save(user1);
     
     User user = new User(signUpRequest.getFirstname(),signUpRequest.getLastname(),
             signUpRequest.getEmail(),
             encoder.encode(java.nio.CharBuffer.wrap(password)),user1);
     
     Set<Role> roles = new HashSet<>();
     Role modRole = roleRepository.findByName(ERole.ROLE_CLIENT)
             .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
         roles.add(modRole);
         
         //user.setRoles(ERole.ROLE_CLIENT);
     // Set<String> strRoles = signUpRequest.getRole();
     

      /*if (strRoles == null) {
        Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
      } else {
        strRoles.forEach(role -> {
          switch (role) {
          case "admin":
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);

            break;
          case "client":
            Role modRole = roleRepository.findByName(ERole.ROLE_CLIENT)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(modRole);
            
            break;
          case "agent":
              Role agentRole = roleRepository.findByName(ERole.ROLE_AGENT)
                  .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
              roles.add(agentRole);
          default:
            Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
          }
        });
      }*/
      //EmailServiceImp emailService = new EmailServiceImp();
     
      //emailService.sendEmail(String.valueOf(password),signUpRequest.getEmail());
     user.setRoles(roles);
      userRepository.save(user);

      return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    /*
    @PostMapping(value="/clients", consumes = {"application/json"})
    public Client addClient(@Valid @RequestBody Client std) {
    	//public User(@NotBlank @Size(max = 30) String firstname, @NotBlank @Size(max = 30) String lastname, @Email String email, String password, Set<Role> roles) {

    	User user = new User(std.getFirstname(),std.getLastname(),std.getEmail());
        return serv.save(std);
    }    */
    
    
    @PutMapping("/update_client/{id}")
    public Client updateClient(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Client newstd) {
   	 Client stdu = serv.findById(id)
                                     .orElseThrow(()->new AgentNotFoundException("Client with "+id+" is Not Found!"));
        stdu.setFirstname(newstd.getFirstname());
        stdu.setLastname(newstd.getLastname());
        stdu.setPhone(newstd.getPhone());
        stdu.setEmail(newstd.getEmail());
        stdu.setConfirmationEmail(newstd.getConfirmationEmail());
        stdu.setAddress(newstd.getAddress());
        stdu.setDateOfBirth(newstd.getDateOfBirth());
        
        User user = user_serv.findByClient(stdu);
        user.setFirstname(newstd.getFirstname());
        user.setLastname(newstd.getLastname());
        user.setEmail(newstd.getEmail());
        
        userRepository.save(user); 

        
        return serv.save(stdu);   
    }           
    @DeleteMapping(value="/clients/{id}")
    public String deleteClient(@PathVariable("id") @Min(1) int id) {
   	 Client std = serv.findById(id)
                                     .orElseThrow(()->new AgentNotFoundException("Client with "+id+" is Not Found!"));
   	 serv.deleteById(std.getId());
        return "Client with ID :"+id+" is deleted";            
    }
    
    @PostMapping("/debit/{accountId}/{amount}")
    public void debit(@PathVariable String accountId,@PathVariable double amount) throws BankAccountNotFoundException, BalanceNotSufficientException {
        Compte bankAccount=bankAccountRepository.findById(accountId)
                .orElseThrow(()->new BankAccountNotFoundException("BankAccount not found"));
        if(bankAccount.getBalance()<amount)
            throw new BalanceNotSufficientException("Balance not sufficient");
        AccountOperation accountOperation=new AccountOperation();
        accountOperation.setType(OperationType.DEBIT);
        accountOperation.setAmount(amount);
        accountOperation.setDescription(null);
        accountOperation.setOperationDate(null);
        accountOperation.setBankaccount(bankAccount);
        accountOperationRepository.save(accountOperation);
        bankAccount.setBalance(bankAccount.getBalance()-amount);
        bankAccountRepository.save(bankAccount);
    }

    @PostMapping("/credit/{accountId}/{amount}")
    public void credit(@PathVariable String accountId,@PathVariable double amount) throws BankAccountNotFoundException {
        Compte bankAccount=bankAccountRepository.findById(accountId)
                .orElseThrow(()->new BankAccountNotFoundException("BankAccount not found"));
        AccountOperation accountOperation=new AccountOperation();
        accountOperation.setType(OperationType.CREDIT);
        accountOperation.setAmount(amount);
        accountOperation.setOperationDate(null);
        accountOperation.setBankaccount(bankAccount);
        accountOperationRepository.save(accountOperation);
        bankAccount.setBalance(bankAccount.getBalance()+amount);
        bankAccountRepository.save(bankAccount);
    }
	@PostMapping("/transfer/{accountIdSource}/{accountIdDestination}/{amount}")
    public void transfer(@PathVariable String accountIdSource,@PathVariable String accountIdDestination,@PathVariable double amount) throws BankAccountNotFoundException, BalanceNotSufficientException {
        debit(accountIdSource,amount);
        credit(accountIdDestination,amount);
    }
	
	@GetMapping("/Historique/{id}")
	public List<AccountOperation> findByBankAccountId(@PathVariable int id) {
		
        return clietOpServ.find(id);
    }

	@GetMapping("/profil")
	  public Object getInfos() {
		
		  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  String username;
		  if (principal instanceof UserDetails) {
		     username = ((UserDetails)principal).getUsername();
		  } else {
		    username = principal.toString();
		  }
		  
		  System.out.println(username);  
		  Optional<Client> user= serv.findByEmail(username);
		  
		  return user;
	  }
	
	
	/*@GetMapping("/getImpayed")
	  public String getImpayed() {
		this.getInfos();
		return null;
	  }
	  */
	@GetMapping("/payed/{id}")
	public List<Facture> find(@PathVariable int id)
	{
		return fact_serv.find(id);
	 }
	
	@GetMapping("/facture/{id}")
	public Facture findFacture(@PathVariable int id)
	{
		return fact_serv.findById(id);
	 }
   
	 @GetMapping("/updateFacture/{id}/{factureid}")
	public int updateFacture(@PathVariable int id,@PathVariable int factureid)
	{
		return fact_serv.update(id,factureid);
	}
	 
	
	
	  
}
