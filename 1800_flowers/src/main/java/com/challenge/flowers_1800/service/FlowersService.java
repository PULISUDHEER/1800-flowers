package com.challenge.flowers_1800.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.challenge.flowers_1800.entity.Flowers;
import com.challenge.flowers_1800.task.FlowersTask;

@Service
public class FlowersService {

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	FlowersTask task;

	List<Flowers> list;

	public List<Flowers> updateList(String url, Flowers details) throws Exception {

		list = Optional.ofNullable(list)
				.orElse(new ArrayList<>(Arrays.asList(restTemplate.getForObject(url, Flowers[].class))));
		return task.printUpdates(details, list);
	}

	public Map<String, Integer> countUsers(String url) {
		list = Optional.ofNullable(list)
				.orElse(new ArrayList<>(Arrays.asList(restTemplate.getForObject(url, Flowers[].class))));
		return task.printCount(list);
	}
}