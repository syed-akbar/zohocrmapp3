package com.zoho.service;

import java.util.List;

import com.zoho.entities.Lead;

public interface LeadService {

public	void saveOneLead(Lead lead);

public List<Lead> listLeads();

public Lead getOneLead(long id);

public void deleteOneLead(long id);

}
