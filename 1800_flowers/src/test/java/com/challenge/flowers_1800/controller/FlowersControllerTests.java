package com.challenge.flowers_1800.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.challenge.flowers_1800.service.FlowersService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@WebMvcTest
public class FlowersControllerTests {

	@MockBean
	FlowersService service;

	@Autowired
	MockMvc mvc;

	ObjectMapper obj = new ObjectMapper();

	@Test
	void uniqueUserIdsTest() throws Exception {

		mvc.perform(get("/1800-flowers").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	void updateTest() throws Exception {
		String reqBody = "{\"userId\":1,\"title\":\"1800flowers\", \"body\":\"1800flowers\"}";
		mvc.perform(put("/1800-flowers").content(reqBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
}
