package com.practice.stockMarket1.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.stockMarket1.Entity.Company;
import com.practice.stockMarket1.Entity.IPODetails;
import com.practice.stockMarket1.service.CompanyService;

@RestController
public class CompanyController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService service;
	
	@PostMapping("/addCompany")
	public Company addCompany(@RequestBody Company company) {
		return service.saveCompany(company);
	}
	
	@PutMapping("/updateCompany")
	public Company updateCompany(@RequestBody Company company) {
		return service.updateCompany(company);
	}
	
	@GetMapping("/getCompany/{id}")
	public Company getCompany(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("/getIpoFromCompany/{id}")
	public IPODetails getIpoFromCompany(@PathVariable int id) {
		Company company = service.findById(id);
		return company.getIpo();
	}	
	
	@GetMapping("/searchCompany/{searchString}")
	public List<Company> searchCompany(@PathVariable String searchString) {
		return service.searchCompany(searchString);
	}

}
