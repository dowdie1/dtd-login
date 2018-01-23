package com.login.controller;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author do119845 - this controller overrides the cutom behaviour of the sprong framework. 
 * If this was not included then the framework would look for the standard /templates/connectedfacebook.html
 * file - and it not there then an error would be thrown. 
 * 
 * We dont want to include this static template - we want to go to the standard page loginSuccess.html - shared 
 * by social media (facebook) logon and the standard username / password logon
 * 
 * overriding this controller is straight forward - simply do the connectedView to redirect to the associated controller the 
 * manages the /facebook path - in our case this is FacebookController. 
 * 
 * In the method signature - providerId - is provided by te framework on the /connect/facebook call that is triggered in the form logon
 * see the html file loginForm.html
 * 
 */

@Controller
@RequestMapping("/connect")
public class ConnectChangeController extends ConnectController {

	public ConnectChangeController(ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository) {
		super(connectionFactoryLocator, connectionRepository);
	}
	
	@Override
    protected String connectedView(String providerId) {
        return "redirect:/"+providerId;
    }

}