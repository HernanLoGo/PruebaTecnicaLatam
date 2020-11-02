package com.logo.pruebalatam.back.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@WebMvcTest
public class BackControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void validInput_thenReturns200() throws Exception {

//		mockMvc.perform(post("/forums/{forumId}/register", 42L).contentType("application/json")
//				.param("sendWelcomeMail", "true").content(objectMapper.writeValueAsString(user)))
//				.andExpect(status().isOk());

	}

}
