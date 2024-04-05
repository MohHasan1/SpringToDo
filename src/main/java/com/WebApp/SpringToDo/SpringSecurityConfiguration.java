package com.WebApp.SpringToDo;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		
		
		http.csrf(csrf -> csrf.disable());
		http.headers(header -> header.frameOptions(fo -> fo.disable()));
		
		return http.build();	
	}
	
}
