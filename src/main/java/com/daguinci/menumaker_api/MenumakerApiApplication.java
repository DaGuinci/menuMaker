package com.daguinci.menumaker_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.daguinci.menumaker_api.auth.Role;
import com.daguinci.menumaker_api.auth.User;
import com.daguinci.menumaker_api.auth.UserService;

@SpringBootApplication
@ComponentScan(basePackages = "com.daguinci.menumaker_api")
@EnableJpaRepositories(basePackages = "com.daguinci.menumaker_api")
public class MenumakerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenumakerApiApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			// userService.saveRole(new Role("ROLE_USER"));
			// userService.saveRole(new Role("ROLE_CONTRIBUTOR"));
			// userService.saveRole(new Role("ROLE_ADMIN"));
			// userService.saveRole(new Role("ROLE_SUPER_ADMIN"));

			userService.saveUser(new User("John Doe", "john", "1234", Role.USER));
			// userService.saveUser(new User("Jane Doe", "jane", "1234", Role.CONTRIBUTOR));
			// userService.saveUser(new User("Tom Smith", "tom", "1234", Role.ADMIN));
			// userService.saveUser(new User("Jerry Smith", "jerry", "1234", Role.SUPER_ADMIN));

			// userService.addRoleToUser("john", "ROLE_USER");
			// userService.addRoleToUser("jane", "ROLE_CONTRIBUTOR");
			// userService.addRoleToUser("Jane", "ROLE_USER");
			// userService.addRoleToUser("tom", "ROLE_ADMIN");
			// userService.addRoleToUser("jerry", "ROLE_SUPER_ADMIN");
		};
	}

}
