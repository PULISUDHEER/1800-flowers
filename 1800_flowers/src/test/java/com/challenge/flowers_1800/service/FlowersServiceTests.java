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
import org.springframework.web.client.RestTemplate;

import com.challenge.flowers_1800.entity.Flowers;
import com.challenge.flowers_1800.task.FlowersTask;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FlowersServiceTests {
	
	@InjectMocks
	FlowersService service;
	
	@Mock
	FlowersTask task;
	
	ObjectMapper obj = new ObjectMapper();
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	List<Flowers> list;
	
	String url ="http://jsonplaceholder.typicode.com/posts"; 
	
	@Test
	void updateListTest() throws Exception {
		
		Flowers[] value = new Flowers[1];
		value[0]= new Flowers(1,1,"title", "Body");
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Flowers[].class)).thenReturn(value);
		String reqBody = "{\"userId\":1,\"title\":\"1800flowers\", \"body\":\"1800flowers\"}";
		Flowers details = obj.readValue(reqBody, Flowers.class);
		assertNotNull(service.updateList(url, details));
		
	}
	
	@Test
	void countUsersTest() throws Exception {
		Flowers[] value = new Flowers[1];
		value[0]= new Flowers(1,1,"title", "Body");
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Flowers[].class)).thenReturn(value);
		assertNotNull(service.countUsers(url));
		
	}

}
