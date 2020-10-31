package com.logo.pruebalatam.back.service.rest.call;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.logo.pruebalatam.back.domain.Poem;

@Service
public class RandomPoemServiceImpl implements RandomPoemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RandomPoemServiceImpl.class);

	private final String urlPoem;

	private RestTemplate restTemplate;

	public RandomPoemServiceImpl(RestTemplate restTemplate, @Value("${url.randompoem}") String urlPoem) {
		this.urlPoem = urlPoem;
		this.restTemplate = restTemplate;
	}

	public Poem[] callRandomPoem() {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ResponseEntity<Poem[]> response = null;

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(urlPoem);

		try {
			response = restTemplate.getForEntity( uriBuilder.toUriString() , Poem[].class );

			HttpStatus httpStatus = response.getStatusCode();

			if (httpStatus.is2xxSuccessful()) {
				LOGGER.info("Response: " + gson.toJson(response.getBody()));
				return response.getBody();
			}

		} catch (RestClientException e) {
			LOGGER.error("El sercidor no responde: " + e.getMessage());
		}

		return null;
	}

}
