package com.logo.pruebalatam.back.service.rest.call;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.logo.pruebalatam.back.domain.Poem;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RandomPoemServiceImplTests {

	@InjectMocks
	private RandomPoemServiceImpl instance = new RandomPoemServiceImpl(new RestTemplate(), "");

	@Mock
	private RestTemplate recursoRest;

	@Test
	void callRandomPoem_retornaPoema_OK() throws Exception {

		ResponseEntity<Poem[]> response = new ResponseEntity<>(new Poem[0], HttpStatus.OK);

		Mockito.when(recursoRest.getForEntity("", Poem[].class)).thenReturn(response);

		Poem[] poem = instance.callRandomPoem();

		assertNotNull(poem);

	}
	
	@Test
	void callRandomPoem_retornaPoema_NOK() throws Exception {

		ResponseEntity<Poem[]> response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		Mockito.when(recursoRest.getForEntity("", Poem[].class)).thenReturn(response);

		Poem[] poem = instance.callRandomPoem();

		assertNotNull(poem);

	}


}
