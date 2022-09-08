package com.zoho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Billing;
import com.zoho.repositories.BillingRepository;

@Service
public class BillingServiceImp implements BillingService {
	
	@Autowired
	BillingRepository billingrepo;

	@Override
	public void saveOneBill(Billing bill) {
		billingrepo.save(bill);
	}

}
