package com.challenge.flowers_1800.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.challenge.flowers_1800.entity.Flowers;
import com.challenge.flowers_1800.task.FlowersTask;

@Service
public class FlowersService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	FlowersTask task;

	List<Flowers> list;

	@Value("${Data:http://localhost:}")
	String url;

	public List<Flowers> updateList(Flowers details) throws Exception {
		list = Optional.ofNullable(list)
				.orElse(new ArrayList<>(Arrays.asList(restTemplate.getForObject(url, Flowers[].class))));
		return task.printUpdates(details, list);
	}

	public Map<String, Integer> countUsers() {
		list = Optional.ofNullable(list)
				.orElse(new ArrayList<>(Arrays.asList(restTemplate.getForObject(url, Flowers[].class))));
		return task.printCount(list);
	}
}