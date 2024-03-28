package com.WebApp.SpringToDo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {
	
	@Autowired
	private AuthenticationService authenService;
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String logIn() {
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String redirectToHome(ModelMap model) {
		
		model.addAttribute("username", "hass");
		
		if (authenService.authenticate("hass", "123")) {			
			return "home";
		}
		
		return "login";
	}

}
