package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Billing;
import com.zoho.entities.Contact;
import com.zoho.service.BillingService;
import com.zoho.service.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private BillingService billingservice;
	
	@Autowired
	private ContactService contactservice;
	
	@RequestMapping("/generateBill")
	public String generateBill(@RequestParam("id")long id,ModelMap model) {
		Contact contact = contactservice.getOneContact(id);
		model.addAttribute("contact", contact);
		return "create_bill";
		
	}
	
	@RequestMapping("/saveOneBill")
	public String saveOneBill(@ModelAttribute Billing bill,ModelMap model) {
		billingservice.saveOneBill(bill);
		List<Contact> contacts = contactservice.getAllContacts();
		model.addAttribute("contact", contacts);
		return "list_contacts";
	
		
	}

}
