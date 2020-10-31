package com.logo.pruebalatam.back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logo.pruebalatam.back.service.PruebaTecnicaService;

@RestController
@RequestMapping("/prueba-tecnica")
public class BackController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BackController.class);

	@Autowired
	private PruebaTecnicaService pruebaTecnicaService;
	@RequestMapping(value = "/logica", method = RequestMethod.GET)
	public void LogicaPruebaTecnica(@RequestParam String fechacumpleanio) {
		
		LOGGER.info("Param:" + fechacumpleanio);
		pruebaTecnicaService.logicaPruebaTecnica(fechacumpleanio);

	}

}
