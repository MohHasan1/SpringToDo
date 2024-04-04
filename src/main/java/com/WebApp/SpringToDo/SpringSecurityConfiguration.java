package com.WebApp.SpringToDo;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	// In memory:
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		// Create a user object.
		UserDetails userDetails = createNewUser("hass", "123");
		UserDetails userDetails2 = createNewUser("sum", "123");
		
		// Store the user in the memory and return.
		return new InMemoryUserDetailsManager(userDetails, userDetails2);
		
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = inputPass -> passwordEncoder().encode(inputPass);
		UserDetails userDetails =  User.builder().passwordEncoder(passwordEncoder).username(username).password(password).roles("USER", "ADMIN").build();
		return userDetails;
	}
	
	// Spring security start using this encryption.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
