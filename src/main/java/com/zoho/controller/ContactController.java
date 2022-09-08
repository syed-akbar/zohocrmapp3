package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contact;
import com.zoho.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactservice;
	
	@RequestMapping("/contactinfo")
	public String contactInfo(@RequestParam("id") long id,ModelMap model) {
		Contact contact = contactservice.getOneContact(id);
		model.addAttribute("contact", contact);
		return "contact_info";
		
	}
	
	@RequestMapping("/listofthecontact")
	public String listcontact(ModelMap model) {
		List<Contact> contacts = contactservice.getAllContacts();
		model.addAttribute("contact", contacts);
		return "list_contacts";
		
	}

}
