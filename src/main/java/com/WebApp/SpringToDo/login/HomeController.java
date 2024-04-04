package com.WebApp.SpringToDo.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.put("username", getLoggedInUserName());

		return "home";
	}
	
	private String getLoggedInUserName() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();	
	
	}

}
