package com.login.controller;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.model.UserBean;

@Controller
@RequestMapping("/facebook")
public class FacebookController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;
    
    private UserBean userForm = new UserBean();

    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String loginFacebook(Model model) {
    	
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/login";
        }
    		
        populateUserDetailsFromFacebook(userForm);
        model.addAttribute("user",userForm);              
        
    	return "loginSuccess";
    	
    }

    /**
     * @param userForm - internal Bean representing the User
     */
	protected void populateUserDetailsFromFacebook(UserBean userForm) {
		User user = facebook.userOperations().getUserProfile();
		userForm.setEmail(user.getEmail());
		userForm.setFirstName(user.getFirstName());
		userForm.setLastName(user.getLastName());
		userForm.setUsername(user.getName());
		//userForm.setImage(user.getCover().getSource());
		userForm.setProvider("facebook");
	}
    
}
