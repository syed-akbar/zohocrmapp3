package com.zoho.service;

import java.util.List;

import com.zoho.entities.Contact;

public interface ContactService {

	public void saveOneContact(Contact c);

	public List<Contact> getAllContacts();

	public Contact getOneContact(long id);

}
