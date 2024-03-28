package com.WebApp.SpringToDo.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public Boolean authenticate(String username, String password) {
		
		boolean isValisUserName = username.equalsIgnoreCase("hass");
		boolean isValidPassword = password.equalsIgnoreCase("123");

		return isValisUserName && isValidPassword;
	}

}
