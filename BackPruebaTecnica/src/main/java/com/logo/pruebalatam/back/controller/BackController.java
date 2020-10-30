package com.logo.pruebalatam.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logo.pruebalatam.back.service.PruebaTecnicaService;

@RestController
@RequestMapping("/prueba-tecnica")
public class BackController {

	@Autowired
	private PruebaTecnicaService pruebaTecnicaService;

	@RequestMapping(value = "/logica", method = RequestMethod.GET)
	public void LogicaPruebaTecnica() {

		pruebaTecnicaService.logicaPruebaTecnica();

	}

}
