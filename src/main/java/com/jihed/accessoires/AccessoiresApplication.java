package com.jihed.accessoires;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.entities.Role;
import com.jihed.accessoires.entities.User;
import com.jihed.accessoires.service.AccessoireService;
import com.jihed.accessoires.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class AccessoiresApplication implements CommandLineRunner{
	
	AccessoireService accessoireService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration; 
	@Autowired  
	 PasswordEncoder passwordEncoder;
	@Autowired 
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(AccessoiresApplication.class, args);
		System.out.println("jihed");
	}
	
	 
	 /*
	  * @PostConstruct 
	  * void init_users() { 
	  //ajouter les rôles 
	  userService.addRole(new Role(null,"ADMIN")); 
	  userService.addRole(new Role(null,"AGENT")); 
	  userService.addRole(new Role(null,"USER")); 
	   
	  //ajouter les users 
	  userService.saveUser(new User(null,"admin","123",true,null)); 
	  userService.saveUser(new User(null,"nadhem","123",true,null)); 
	  userService.saveUser(new User(null,"user1","123",true,null)); 
	   
	  //ajouter les rôles aux users 
	  userService.addRoleToUser("admin", "ADMIN"); 
	   
	  userService.addRoleToUser("nadhem", "USER"); 
	  userService.addRoleToUser("nadhem", "AGENT"); 
	   
	  userService.addRoleToUser("user1", "USER");   
	 } */
	   

	@Override
	public void run(String... args) throws Exception {
		 
	       //System.out.println("Password Encoded BCRYPT :******************** "); 
	    //   System.out.println(passwordEncoder.encode("123")); 
		//accessoireService.saveAccessoire(new Accessoire("tapis","jaune",50.0,new Date()));
		//accessoireService.saveAccessoire(new Accessoire("camera","mauve",670.0,new Date()));
		//accessoireService.saveAccessoire(new Accessoire("ecran","noir",830.0,new Date()));
		repositoryRestConfiguration.exposeIdsFor(Accessoire.class);
		
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}


}
