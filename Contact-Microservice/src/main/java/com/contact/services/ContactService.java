package com.contact.services;

import java.util.List;

import com.contact.entities.Contact;

public interface ContactService {

	public List<Contact> getContactsOfUser(Long userId);
}
