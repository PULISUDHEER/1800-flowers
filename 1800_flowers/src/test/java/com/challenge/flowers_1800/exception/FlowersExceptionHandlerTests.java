package com.challenge.flowers_1800.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.challenge.flowers_1800.entity.Flowers;
import com.challenge.flowers_1800.task.FlowersTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FlowersExceptionHandlerTests {

	ObjectMapper obj = new ObjectMapper();

	@InjectMocks
	FlowersTask task;

	@Test
	void printUpdatesTest() throws JsonMappingException, JsonProcessingException {

		String reqBody = "{\"userId\":2,\"title\":\"1800flowers\", \"body\":\"1800flowers\"}";
		Flowers details = obj.readValue(reqBody, Flowers.class);
		Flowers[] data = new Flowers[1];
		data[0] = new Flowers(1, 1, "title", "body");
		List<Flowers> list1 = Arrays.asList(data);
		assertThrows(RuntimeException.class, () -> task.printUpdates(details, list1), "UserId not found!");
	}
}
