package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoho.entities.Lead;
import com.zoho.service.LeadService;

@RestController
@RequestMapping("/api/lead")
public class RestLeadController {
	
	@Autowired
	private LeadService leadservice;
	
	@GetMapping
	public List<Lead> getallleads() {
		List<Lead> leads = leadservice.listLeads();
		return leads;
		
	}
	
	@PostMapping
	public ResponseEntity<Lead> saveOnel(@RequestBody Lead lead) {
		leadservice.saveOneLead(lead);
		return new ResponseEntity<Lead>(HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping
	public void updateonel(@RequestBody Lead lead) {
		leadservice.saveOneLead(lead);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletel(@PathVariable("id")long id) {
		leadservice.deleteOneLead(id);
	}
	
	@GetMapping("/lead/{id}")
	public Lead getonel(@PathVariable("id")long id) {
		Lead lead = leadservice.getOneLead(id);
		return lead;
		
	}

}
