package com.project.Ebanking_BackEnd.controllers;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.Ebanking_BackEnd.exceptions.AgentNotFoundException;
import com.project.Ebanking_BackEnd.models.Agent;
import com.project.Ebanking_BackEnd.models.Client;
import com.project.Ebanking_BackEnd.models.ERole;
import com.project.Ebanking_BackEnd.models.Role;
import com.project.Ebanking_BackEnd.models.User;
import com.project.Ebanking_BackEnd.payload.request.AddAgentRequest;
import com.project.Ebanking_BackEnd.payload.request.AddClientRequest;
import com.project.Ebanking_BackEnd.payload.response.MessageResponse;
import com.project.Ebanking_BackEnd.repository.AgentRepository;
import com.project.Ebanking_BackEnd.repository.RoleRepository;
import com.project.Ebanking_BackEnd.repository.UserRepository;
import com.project.Ebanking_BackEnd.services.AgentService;
import com.project.Ebanking_BackEnd.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/agent")
public class AgentController {
	AgentService serv;
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	 @Autowired
	 UserService user_serv;
	  
	@Autowired
	AgentRepository repo;
	 @Autowired
	  PasswordEncoder encoder;
	 @Autowired
	  UserRepository userRepository;
	  @Autowired
	  RoleRepository roleRepository;
    @Autowired
    public AgentController(AgentService serv) {
        this.serv = serv;
    }
    
    @GetMapping(value="/agents")
    public List<Agent> getAllAgents(){
        return serv.getAllAgents();
    }           
    @GetMapping(value="/agents/{id}")
    public Agent getAgentById(@PathVariable("id") @Min(1) int id) {
   	 Agent std = serv.findById(id)
                                    .orElseThrow(()->new AgentNotFoundException("Agent with "+id+" is Not Found!"));
        return std;
    }           
   /* @PostMapping(value="/agent", consumes = {"application/json"})
    public Agent addAgent(@Valid @RequestBody Agent std) {
        return serv.save(std);
    } */          
    
    
    @PostMapping("/addAgent")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AddAgentRequest signUpRequest) {
      /*if (userRepository.existsByUsername(signUpRequest.getUsername())) {
        return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
      }*/

      if (repo.existsByEmail(signUpRequest.getEmail())) {
        return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
      }

      // Create new user's account
     
      
      //Generate password 
      char[] password= User.generatePassword();
      System.out.println("generated password is :  "+password.toString());
      
     Agent user1 = new Agent(signUpRequest.getFirstname(),signUpRequest.getLastname(),signUpRequest.getPhone(),signUpRequest.getAddress(),signUpRequest.getDateOfBirth(),
                           signUpRequest.getEmail(),signUpRequest.getConfirmationEmail(),signUpRequest.getPieceIdentity(),signUpRequest.getN_pieceIdentity(),signUpRequest.getN_Immatr(),signUpRequest.getN_Pattente(),signUpRequest.getPieceJointe()                         );
     
     repo.save(user1);
     
     User user = new User(signUpRequest.getFirstname(),signUpRequest.getLastname(),
             signUpRequest.getEmail(),
             encoder.encode(java.nio.CharBuffer.wrap(password)),user1);
     
     Set<Role> roles = new HashSet<>();
     Role modRole = roleRepository.findByName(ERole.ROLE_AGENT)
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
    
    
    @PutMapping("/update_agent/{id}")
    public <newstd> Agent updateAgent(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Agent newstd) {
    	Agent stdu = serv.findById(id)
                                     .orElseThrow(()->new AgentNotFoundException("Agent with "+id+" is Not Found!"));
    	
        stdu.setFirstname(newstd.getFirstname());
        stdu.setLastname(newstd.getLastname());
        stdu.setDateOfBirth(newstd.getDateOfBirth());
        stdu.setPieceIdentity(newstd.getPieceIdentity());
        stdu.setN_pieceIdentity(newstd.getN_pieceIdentity());
        stdu.setAddress(newstd.getAddress());
        stdu.setEmail(newstd.getEmail());
        stdu.setConfirmationEmail(newstd.getConfirmationEmail());
        stdu.setPhone(newstd.getPhone());
        stdu.setN_Immatr(newstd.getN_Immatr());
        stdu.setN_Pattente(newstd.getN_Pattente());
        stdu.setPieceJointe(newstd.getPieceJointe());
        
        User user = user_serv.findByAgent(stdu);
        user.setFirstname(newstd.getFirstname());
        user.setLastname(newstd.getLastname());
        user.setEmail(newstd.getEmail());
        
        userRepository.save(user); 
        
        return serv.save(stdu);   
    }           
    @DeleteMapping(value="/agent/{id}")
    public String deleteAgent(@PathVariable("id") @Min(1) int id) {
   	 Agent agent = serv.findById(id)
                                     .orElseThrow(()->new AgentNotFoundException("Agent with "+id+" is Not Found!"));
   	 serv.deleteById(agent.getId());
        return "Agent with ID :"+id+" is deleted";            
    }
    @RequestMapping("/upload")
    public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
  	  StringBuilder fileNames = new StringBuilder();
  	  for (MultipartFile file : files) {
  		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
  		  fileNames.append(file.getOriginalFilename()+" ");
  		  try {
  			Files.write(fileNameAndPath, file.getBytes());
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
  	  }
  	  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
  	  return "uploadstatusview";
    }
}
