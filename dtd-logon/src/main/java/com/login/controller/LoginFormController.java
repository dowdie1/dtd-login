package com.login.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.model.UserBean;

@Controller
public class LoginFormController {

    @GetMapping("/login")
    public String loginForm(Model model) {
     
    	model.addAttribute("user", new UserBean());
    	return "loginForm";

    }

    @PostMapping("/login")
    public String loginSubmit(@Valid @ModelAttribute UserBean userForm, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "loginForm";
        }            
        
        model.addAttribute("user", userForm);
        
        return "loginSuccess";
    	
    }

}
