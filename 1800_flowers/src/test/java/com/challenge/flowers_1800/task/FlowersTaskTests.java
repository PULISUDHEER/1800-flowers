package com.challenge.flowers_1800.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.flowers_1800.entity.Flowers;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class FlowersTaskTests {

	@InjectMocks
	FlowersTask task;

	ObjectMapper obj = new ObjectMapper();

	@Test
	void printUpdatesTest() throws Exception {
		String reqBody = "{\"userId\":1,\"title\":\"1800flowers\", \"body\":\"1800flowers\"}";
		Flowers details = obj.readValue(reqBody, Flowers.class);

		String resBody = "[{\"userId\":1,\"id\":1,\"title\":\"1800flowers\",\"body\":\"1800flowers\"}]";
		List<String> expected = Arrays.asList(resBody);

		Flowers[] data = new Flowers[1];
		data[0] = new Flowers(1, 1, "title", "body");
		List<Flowers> list1 = Arrays.asList(data);
		List<String> actual = Arrays.asList(obj.writeValueAsString(task.printUpdates(details, list1)));
		assertEquals(expected, actual);
	}

	@Test
	void printCountTest() throws Exception {

		Flowers[] data = new Flowers[1];
		data[0] = new Flowers(1, 1, "1800flowers", "1800flowers");
		List<Flowers> list1 = Arrays.asList(data);

		assertEquals(1, task.printCount(list1).size());
	}
}
