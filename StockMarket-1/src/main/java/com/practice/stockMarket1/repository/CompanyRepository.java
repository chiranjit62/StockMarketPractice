package com.practice.stockMarket1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.stockMarket1.Entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
