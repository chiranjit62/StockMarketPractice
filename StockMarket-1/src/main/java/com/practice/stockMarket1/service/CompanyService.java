package com.practice.stockMarket1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.stockMarket1.Entity.Company;
import com.practice.stockMarket1.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	CompanyRepository repository;
	
	public Company saveCompany(Company company) {
		return repository.save(company);
	}
	
	public List<Company> getCompanies() {
		return repository.findAll();
	}
	
	public Company findById( int id ) {
		return repository.findById(id).orElse(null);
	}

	public Company updateCompany(Company company) {
		Company existingCompany = repository.findById(company.getId()).orElse(null);
		existingCompany.setTurnOver(company.getTurnOver());
		existingCompany.setCeo(company.getCeo());
		existingCompany.setBoardDirectors(company.getBoardDirectors());
//		existingCompany.setSector(company.getSector());
		existingCompany.setBriefWriteup(company.getBriefWriteup());
		return repository.save(existingCompany);
	}
	
	public void deleteCompany(int id) {
		repository.deleteById(id);
	}
	
	public List<Company> searchCompany(String searchString){
		return repository.getCompanyBySearch(searchString);
	}

}
