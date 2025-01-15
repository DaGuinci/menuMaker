package com.daguinci.menumaker_api;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.daguinci.menumaker_api.auth.AppUser;
import com.daguinci.menumaker_api.auth.Role;
import com.daguinci.menumaker_api.auth.UserService;

@SpringBootApplication
public class MenumakerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenumakerApiApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role("ROLE_USER"));
			userService.saveRole(new Role("ROLE_CONTRIBUTOR"));
			userService.saveRole(new Role("ROLE_ADMIN"));
			userService.saveRole(new Role("ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser("John Doe", "john", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser("Jane Doe", "jane", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser("Tom Smith", "tom", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser("Jerry Smith", "jerry", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("jane", "ROLE_CONTRIBUTOR");
			userService.addRoleToUser("Jane", "ROLE_USER");
			userService.addRoleToUser("tom", "ROLE_ADMIN");
			userService.addRoleToUser("jerry", "ROLE_SUPER_ADMIN");
		};
	}

}
