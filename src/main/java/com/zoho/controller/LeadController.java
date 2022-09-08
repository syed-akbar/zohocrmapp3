package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contact;
import com.zoho.entities.Lead;
import com.zoho.service.ContactService;
import com.zoho.service.LeadService;
import com.zoho.utility.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadservice;
	
	@Autowired
	private EmailService emailservice;
	
	@Autowired
	private ContactService contactservice;
	
	@RequestMapping("/")
	public String createLead() {
		return "create_lead";
		
	}
	
	@RequestMapping("/saveOneLead")
	public String saveOneLead(@ModelAttribute Lead lead,ModelMap model) {
		leadservice.saveOneLead(lead);
		emailservice.sendSimpleMail("akbarsyed628@gmail.com", "Hello", "Asslamualikum");
		model.addAttribute("lead", lead);
		return "lead_info";
		
	}
	
	@RequestMapping("/listleads")
	public String listLeads(ModelMap model) {
		List<Lead> leads = leadservice.listLeads();
		model.addAttribute("lead", leads);
		return "list_lead";
		
	}
	
	@RequestMapping("/convert")
	public String convertOneLead(@RequestParam("id") long id,ModelMap model) {
		Lead lead = leadservice.getOneLead(id);
		Contact c = new Contact();
		c.setFirstName(lead.getFirstName());
		c.setLastName(lead.getLastName());;
		c.setEmail(lead.getEmail());
		c.setMobile(lead.getMobile());
		contactservice.saveOneContact(c);
		leadservice.deleteOneLead(id);
		
		List<Contact> contacts = contactservice.getAllContacts();
		model.addAttribute("contact", contacts);
		
		return "list_contacts";
		
	}
	
	@RequestMapping("/leadinfo")
	public String leadinfo(@RequestParam("id")long id, ModelMap model) {
		Lead lead = leadservice.getOneLead(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}

}
