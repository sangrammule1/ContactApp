package com.nt.service;

import java.util.List;

import com.nt.domain.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer id);
	
	public String validateEmail(String email);
	
	public boolean deleteContactById(Integer id);

}
