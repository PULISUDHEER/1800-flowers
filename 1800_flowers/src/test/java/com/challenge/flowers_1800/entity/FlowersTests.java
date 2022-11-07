package com.challenge.flowers_1800.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FlowersTests {
	ObjectMapper obj = new ObjectMapper();

	@Test
	void flowersTest() throws JsonProcessingException {

		Flowers flowers = new Flowers(1, 1, "title", "body");
		assertNotNull(flowers.getUserId());
		assertNotNull(flowers.getId());
		assertNotNull(flowers.getTitle());
		assertNotNull(flowers.getBody());
		flowers.setUserId(2);
		flowers.setBody("1800flowers");
		flowers.setId(2);
		flowers.setTitle("1800flowers");
		Flowers expected = new Flowers(2, 2, "1800flowers", "1800flowers");
		assertEquals(obj.writeValueAsString(expected), obj.writeValueAsString(flowers));
	}

}
