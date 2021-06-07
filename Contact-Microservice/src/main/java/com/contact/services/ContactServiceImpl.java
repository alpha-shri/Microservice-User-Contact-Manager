package com.contact.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entities.Contact;

@Service
public class ContactServiceImpl implements ContactService{
	
	List<Contact> contactList = List.of(
						new Contact(1L, "mukesh@gmail.com", "Mukesh Singh", 100L),
						new Contact(2L, "rohan@gmail.com", "Rohan Tiwari", 200L),
						new Contact(3L, "janaki@gmail.com", "Janaki Ballabh", 300L),
						new Contact(4L, "msdhoni@gmail.com", "MS Dhoni", 100L)			
				);

	@Override
	public List<Contact> getContactsOfUser(Long userId) {
		
		return contactList.stream()
						  .filter(c -> c.getUserID().equals(userId))
						  .collect(Collectors.toList());
	}

}
