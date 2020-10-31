package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.domain.Contact;
import com.nt.entity.ContactEntity;
import com.nt.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo repo;

	@Override
	public boolean saveContact(Contact contact) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSwitch("Y");
		ContactEntity save = repo.save(entity);
		return save.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		//use repo
		List<ContactEntity> contactEntity = repo.findByActiveSwitch("Y");
		List<Contact> contacts=new ArrayList<Contact>();
		contactEntity.forEach(entity->{
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			contacts.add(c);
		});
		return contacts;
	}

	@Override
	public Contact getContactById(Integer id) {
		//use repo
		Optional<ContactEntity> entity = repo.findById(id);
		Contact contact = new Contact();
		if(entity.isPresent()) {
			contact.setContactName(entity.get().getContactName());
			contact.setEmail(entity.get().getEmail());
			contact.setContactNum(entity.get().getContactNum());
		}
		return contact;
	}
	
	@Override
	public String validateEmail(String email) {
		//use repo
		ContactEntity contactEntity = repo.findByEmail(email);
		String email2 = contactEntity.getEmail();
		if(email2==null) {
			return "UNIQUE";
		}
		return "DUPLICATE";
	}
	
	@Override
	public boolean deleteContactById(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
