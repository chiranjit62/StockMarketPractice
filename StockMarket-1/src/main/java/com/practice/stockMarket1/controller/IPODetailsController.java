package com.practice.stockMarket1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.stockMarket1.Entity.IPODetails;
import com.practice.stockMarket1.response.Response;
import com.practice.stockMarket1.service.IPODetailsService;


@RestController
public class IPODetailsController {

	@Autowired
	IPODetailsService service;
	
	@PostMapping("/addIpo")
	public Response addIpo(@RequestBody IPODetails ipo) {
	    HashMap<String, String> map = new HashMap<>();
	    
	    return new Response("ok", "ok");
//		return service.saveIpo(ipo);
	}
	
	@PutMapping("/updateIpo")
	public IPODetails updateIpo(@RequestBody IPODetails ipo) {
		return service.updateIpo(ipo);
	}
	
	@GetMapping("/ipos")
	public List<IPODetails> getIpos(){
		return service.getIpos();
	}
}