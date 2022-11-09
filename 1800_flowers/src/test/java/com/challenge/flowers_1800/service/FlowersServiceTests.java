package com.challenge.flowers_1800.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.web.client.RestTemplate;

import com.challenge.flowers_1800.entity.Flowers;
import com.challenge.flowers_1800.task.FlowersTask;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FlowersServiceTests {

	@Mock
	FlowersService service;

	@Mock
	FlowersTask task;

	ObjectMapper obj = new ObjectMapper();

	RestTemplate template = new RestTemplate();

	@Mock
	List<Flowers> list;

	@Test
	void updateListTest() throws Exception {
		String reqBody = "{\"userId\":1,\"title\":\"1800flowers\", \"body\":\"1800flowers\"}";
		Flowers details = obj.readValue(reqBody, Flowers.class);
		assertEquals(task.printUpdates(details, list).size(), service.updateList(details).size());
	}

	@Test
	void countUsersTest() throws Exception {
		assertEquals(task.printCount(list).size(), service.countUsers().size());

	}

}
