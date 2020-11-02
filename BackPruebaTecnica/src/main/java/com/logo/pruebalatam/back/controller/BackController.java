package com.logo.pruebalatam.back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logo.pruebalatam.back.domain.Response;
import com.logo.pruebalatam.back.service.PruebaTecnicaService;

@CrossOrigin(origins = {"http://localhost:4200"} )
@RestController
@RequestMapping("/prueba-tecnica")
public class BackController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BackController.class);
	
	@Autowired
	private PruebaTecnicaService pruebaTecnicaService;
	
	@GetMapping(path = "/logica")
	public ResponseEntity<Response> logicaPruebaTecnica(@RequestParam String fechacumpleanio) {
		
		LOGGER.info("Param: {}", fechacumpleanio);
		Response response = pruebaTecnicaService.logicaPruebaTecnica(fechacumpleanio);
		
		LOGGER.info("Response: {}", response);
		
		if(response!=null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}
		
	}

}
