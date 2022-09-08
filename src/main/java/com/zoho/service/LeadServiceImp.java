package com.zoho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Lead;
import com.zoho.repositories.LeadRepository;

@Service
public class LeadServiceImp implements LeadService {
	
	@Autowired
	private LeadRepository leadrepo;

	@Override
	public void saveOneLead(Lead lead) {
		leadrepo.save(lead);
		
	}

	@Override
	public List<Lead> listLeads() {
		List<Lead> leads = leadrepo.findAll();
		return leads;
	}

	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteOneLead(long id) {
		leadrepo.deleteById(id);
	}

}
