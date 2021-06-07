package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.constants.UserConstants;
import com.user.entities.Contact;
import com.user.entities.User;
import com.user.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId) {
		 User user = this.userService.getUser(userId);
		 
		 String _url= UserConstants.LOCAL_HOST_USER + userId;
		 
		 List<Contact> contacts = this.restTemplate
				 					  .getForObject(_url, List.class);
		 
		 user.setContacts(contacts);
		 
		 return user;
	}

}
