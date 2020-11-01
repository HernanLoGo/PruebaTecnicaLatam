package com.logo.pruebalatam.back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logo.pruebalatam.back.domain.Response;
import com.logo.pruebalatam.back.service.PruebaTecnicaService;

@RestController
@RequestMapping("/prueba-tecnica")
public class BackController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BackController.class);

	@Autowired
	private PruebaTecnicaService pruebaTecnicaService;
	
	@GetMapping("/logica")
	public Response logicaPruebaTecnica(@RequestParam String fechacumpleanio) {
		
		LOGGER.info("Param: {}", fechacumpleanio);
		Response response = pruebaTecnicaService.logicaPruebaTecnica(fechacumpleanio);
		
		LOGGER.info("Response: {}", response);
		
		return response;

	}

}
