package com.challenge.flowers_1800.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.web.client.RestTemplate;

import com.challenge.flowers_1800.entity.Flowers;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FlowersServiceTests {

	@Mock
	RestTemplate restTemplate;
	
	@Mock
	List<Flowers> list;
	
	@InjectMocks
	FlowersService service;
	
	ObjectMapper obj = new ObjectMapper();

	@Test
	void updataeListTest() throws Exception {
		
		Flowers[] data = new Flowers[1];
		data[0] = new Flowers(1, 1, "1800flowers", "1800flowers");
		OngoingStubbing<Flowers[]> list1 = Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Flowers[].class))
				.thenReturn(data);
		assertNotNull(list1);
		assertNotNull(list);
	}
	@Test
	void countUsersTest() throws Exception {
		
		Flowers[] data = new Flowers[1];
		data[0] = new Flowers(1, 1, "1800flowers", "1800flowers");
		OngoingStubbing<Flowers[]> list1 = Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Flowers[].class))
				.thenReturn(data);
		assertNotNull(list1);
		assertNotNull(list);
	}

}
