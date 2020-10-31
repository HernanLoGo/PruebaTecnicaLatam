package com.logo.pruebalatam.back.service;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.time.Period;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.pruebalatam.back.domain.Poem;
import com.logo.pruebalatam.back.service.rest.call.RandomPoemServiceImpl;

@Service
public class PruebaTecnicaServiceImpl implements PruebaTecnicaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PruebaTecnicaServiceImpl.class);

	@Autowired
	private RandomPoemServiceImpl randomPoemRestCall;

	public void logicaPruebaTecnica(String fechaCumpleanio) {

		Poem[] poems = null;
		long numberOFDays = 0L;

		String ArrFecha[] = fechaCumpleanio.split("-");

		LocalDate fechaActual = LocalDate.now();

		LocalDate dateCumpleanio = LocalDate.parse(fechaCumpleanio);

		Period period = Period.between(dateCumpleanio, fechaActual);

		if (esCumpleanios(period)) {
			
			poems = randomPoemRestCall.callRandomPoem();
			
		} else {
			
			LocalDate cumpleanioFuturo = dateCumpleanio.plusYears(period.getYears()+1);
			numberOFDays = DAYS.between(fechaActual, cumpleanioFuturo);
			LOGGER.info("Dias faltantes: " + numberOFDays);
			
		}

	}

	private boolean esCumpleanios(Period period) {
		return period.getMonths() == 0 && period.getDays() == 0;
	}

}
