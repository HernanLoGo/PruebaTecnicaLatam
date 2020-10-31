package com.logo.pruebalatam.back.service;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.pruebalatam.back.domain.Poem;
import com.logo.pruebalatam.back.domain.Response;
import com.logo.pruebalatam.back.domain.ServiceStatus;
import com.logo.pruebalatam.back.service.rest.call.RandomPoemServiceImpl;

@Service
public class PruebaTecnicaServiceImpl implements PruebaTecnicaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PruebaTecnicaServiceImpl.class);

	private static final int ERROR_CODE = -1;
	private static final int OK_CODE = 0;
	private static final String OK_POEM = "ok_poem";
	private static final String OK_DIAS = "ok_dias";

	@Autowired
	private RandomPoemServiceImpl randomPoemRestCall;

	public Response logicaPruebaTecnica(String fechaCumpleanio) {

		Poem[] poems = null;
		Response response = new Response();

		LocalDate fechaActual = LocalDate.now();
		LocalDate dateCumpleanio = LocalDate.parse(fechaCumpleanio);

		Period period = Period.between(dateCumpleanio, fechaActual);

		if (esCumpleanios(period)) {

			poems = randomPoemRestCall.callRandomPoem();
			response = setResultadoPoem(poems);

		} else {
			
			response = setResultadoDiasCumpleanios(period, fechaActual, dateCumpleanio);
		}
		
		return response;
	}
	

	private Response setResultadoDiasCumpleanios(Period period, LocalDate fechaActual, LocalDate dateCumpleanio) {
		
		Response response = new Response();
		
		LocalDate cumpleanioFuturo = dateCumpleanio.plusYears(period.getYears() + 1);
		
		long numberOFDays = DAYS.between(fechaActual, cumpleanioFuturo);
		LOGGER.info("Dias faltantes: " + numberOFDays);
		
		response.setDiasParaCumpleanios(numberOFDays);
		
		ServiceStatus serviceStatus = new ServiceStatus(0, OK_DIAS);
		response.setServiceStatus(serviceStatus);
		
		return response;
		
	}


	private Response setResultadoPoem(Poem[] poems) {
		
		Response response = new Response();
		ServiceStatus serviceStatus;
		
		if (poems != null && poems.length > 0) {
			
			response.setPoems(obtenerPoemaAleatorio(poems));
			serviceStatus = new ServiceStatus(OK_CODE, OK_POEM);
			
		} else {
			
			serviceStatus = new ServiceStatus(ERROR_CODE, "Error al conectar al obtener poemas");
		}
		
		response.setServiceStatus(serviceStatus);
		
		return response;
		
	}
	

	private Poem obtenerPoemaAleatorio(Poem[] poems) {

		Random generator = new Random();
		int randomIndex = generator.nextInt(poems.length);
		return poems[randomIndex];

	}
	

	private boolean esCumpleanios(Period period) {

		return period.getMonths() == 0 && period.getDays() == 0;

	}

}
