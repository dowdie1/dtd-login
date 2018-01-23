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
public class RegistrationFormController {

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("userForm", new UserBean());
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String loginSubmit(@Valid @ModelAttribute UserBean userForm, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "registrationForm";
        }
        
        //TO DO - DN - Validate insert of Registration details
        
        //TO DO - DN - Insert the user into the DB
        
        
        model.addAttribute("user", userForm);
        
        // TO DO - Send email confirmation
        
        //Confirmation 
        return "loginSuccess";
    	
    }

}
