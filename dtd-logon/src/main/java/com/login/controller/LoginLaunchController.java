package com.login.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLaunchController {

    @GetMapping("/")
    public String loginLaunchForm(Model model) {
    	
    	if(model.containsAttribute("user")) {
    		System.out.println("user already logged in");
    		return "loginSuccess";
    		
    	}else {
    		System.out.println("user not loged in");
    		return "loginLaunch";
    	}
    }
    
    @GetMapping("/logout")
    public String logout(Model model) {
    	
    	//TO DO - Implement the logic here to clear the cookies and logout of the application 
    	
        return "loginLaunch";
    }

}
