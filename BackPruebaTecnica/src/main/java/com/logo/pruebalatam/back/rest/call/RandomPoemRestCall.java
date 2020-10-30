package com.logo.pruebalatam.back.rest.call;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.logo.pruebalatam.back.domain.Poem;

@Service
public class RandomPoemRestCall {

	static Logger log = LogManager.getLogger();

	@Value("${urlPoem}")
	private String urlPoem;

	public Poem[] callRandomPoem() {

		RestTemplate restTemplate = new RestTemplate();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		ResponseEntity<Poem[]> response = restTemplate.getForEntity(urlPoem, Poem[].class);

		if (response != null) {
			log.info("Response: " + gson.toJson(response.getBody()));
			return response.getBody();
		}
		
		return null;

	}
}
