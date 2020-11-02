package com.logo.pruebalatam.back.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.logo.pruebalatam.back.domain.Poem;
import com.logo.pruebalatam.back.domain.Poet;
import com.logo.pruebalatam.back.domain.Response;
import com.logo.pruebalatam.back.domain.ServiceStatus;
import com.logo.pruebalatam.back.service.rest.call.RandomPoemService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PruebaTecnicaServiceImplTests {

	@InjectMocks
	private PruebaTecnicaServiceImpl instance = new PruebaTecnicaServiceImpl();

	@Mock
	private RandomPoemService serviceRandomPoem;

	@Test
	void logicaPruebaTecnica_retornaDiasParaCumpleanios_OK() throws Exception {
		String fechaCumpleanio = "2019-10-30";

		Response response = new Response();
		response.setServiceStatus(new ServiceStatus(0, "ok_dias"));

		Response resultadoPrueba = instance.logicaPruebaTecnica(fechaCumpleanio);

		assertEquals(response.getServiceStatus(), resultadoPrueba.getServiceStatus());

	}

	@Test
	void logicaPruebaTecnica_retornaPoema_OK() throws Exception {

		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechaCumpleanio = localDate.format(formatter);

		Poem poem = new Poem();
		poem.setContent("");
		poem.setPoet(new Poet());
		poem.setContent("");
		poem.setUrl("");

		Poem[] poems = { poem };

		Response response = new Response();
		response.setServiceStatus(new ServiceStatus(0, "ok_poem"));

		Mockito.when(serviceRandomPoem.callRandomPoem()).thenReturn(poems);

		Response resultadoPrueba = instance.logicaPruebaTecnica(fechaCumpleanio);

		assertEquals(response.getServiceStatus(), resultadoPrueba.getServiceStatus());

	}
	
	@Test
	void logicaPruebaTecnica_retornaPoema_NOK() throws Exception {

		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechaCumpleanio = localDate.format(formatter);

		Response response = new Response();
		response.setServiceStatus(new ServiceStatus(-1, "Error al conectar al obtener poemas"));

		Mockito.when(serviceRandomPoem.callRandomPoem()).thenReturn(new Poem[0]);

		Response resultadoPrueba = instance.logicaPruebaTecnica(fechaCumpleanio);

		assertEquals(response.getServiceStatus(), resultadoPrueba.getServiceStatus());

	}

}
