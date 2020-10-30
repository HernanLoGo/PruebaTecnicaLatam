package com.logo.pruebalatam.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.pruebalatam.back.rest.call.RandomPoemRestCall;

@Service
public class PruebaTecnicaServiceImpl implements PruebaTecnicaService{

	@Autowired
	private RandomPoemRestCall randomPoemRestCall;
	
	public void logicaPruebaTecnica() {
		
		randomPoemRestCall.callRandomPoem();
		
	}
	
}
