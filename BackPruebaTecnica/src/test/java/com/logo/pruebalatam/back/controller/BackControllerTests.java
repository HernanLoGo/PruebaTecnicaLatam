package com.logo.pruebalatam.back.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.logo.pruebalatam.back.domain.Poem;
import com.logo.pruebalatam.back.domain.Response;
import com.logo.pruebalatam.back.service.PruebaTecnicaService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BackControllerTests {

	@InjectMocks
	private BackController service;

	@Mock
	private PruebaTecnicaService pruebaTecnicaService;

	@Test
	void validInput_thenReturns200() throws Exception {

		ResponseEntity<Response> response = new ResponseEntity<>(new Response(), HttpStatus.OK);
		Mockito.when(pruebaTecnicaService.logicaPruebaTecnica("")).thenReturn(new Response());
		ResponseEntity<Response> resp = service.logicaPruebaTecnica("");
		
		assertEquals(resp.getStatusCode(), response.getStatusCode());

	}
	
	@Test
	void validInput_thenReturns204() throws Exception {

		ResponseEntity<Response> response = new ResponseEntity<>(new Response(), HttpStatus.NO_CONTENT);
		Mockito.when(pruebaTecnicaService.logicaPruebaTecnica("")).thenReturn(null);
		ResponseEntity<Response> resp = service.logicaPruebaTecnica("");
		
		assertEquals(resp.getStatusCode(), response.getStatusCode());

	}

}
