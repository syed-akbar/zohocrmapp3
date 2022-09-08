package com.zoho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Contact;
import com.zoho.repositories.ContactRepository;

@Service
public class ContactServiceImp implements ContactService {
	
	@Autowired
	private ContactRepository contactrepo;

	@Override
	public void saveOneContact(Contact c) {
		contactrepo.save(c);
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactrepo.findAll();
		return contacts;
	}

	@Override
	public Contact getOneContact(long id) {
		Optional<Contact> findById = contactrepo.findById(id);
		Contact contact = findById.get();
		return contact;
	}

}
