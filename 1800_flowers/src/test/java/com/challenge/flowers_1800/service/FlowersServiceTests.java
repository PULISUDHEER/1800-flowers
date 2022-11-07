package com.challenge.flowers_1800.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.web.client.RestTemplate;

import com.challenge.flowers_1800.entity.Flowers;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FlowersServiceTests {

	@Mock
	RestTemplate restTemplate;

	@Test
	void flowersServiceTest() {
		Flowers[] data = new Flowers[1];
		data[0] = new Flowers(1, 1, "1800flowers", "1800flowers");
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Flowers[].class))
				.thenReturn(data);
	}

}
