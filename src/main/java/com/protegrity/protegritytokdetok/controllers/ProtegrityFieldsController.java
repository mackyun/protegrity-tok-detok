package com.protegrity.protegritytokdetok.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protegrity.protegritytokdetok.model.ProtegrityFields;
import com.protegrity.protegritytokdetok.repositories.ProtegrityFieldsDAO;
import com.protegrity.protegritytokdetok.services.TokenizeService;

import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
public class ProtegrityFieldsController {

	@Autowired
	ProtegrityFieldsDAO repo;
	@Autowired
	TokenizeService service;
	
	@GetMapping("/getAndUpdate")
	public void getAndUpdate() {
		List<ProtegrityFields> list =repo.findAll();
		
		List<ProtegrityFields> updatedList= new ArrayList<>();
		long count = 0;
		for (ProtegrityFields data : list) {
			
			updatedList.add(service.getTokenizeData(data));
		}
		if(list.size()==updatedList.size()) {
			for(ProtegrityFields data:updatedList ) {
				count = count+repo.update(data.getId(),data.getSSN(),data.getFirstName(),data.getLastName(),data.getDOB(),data.getEmail(),data.getOtherID()) ;
			}
		   log.info(updatedList.size()+" records updated");
		}
		
		System.out.println("Count of updated records " + count);

	}
}
