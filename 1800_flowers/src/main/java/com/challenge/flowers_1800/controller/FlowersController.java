package com.challenge.flowers_1800.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.flowers_1800.entity.Flowers;
import com.challenge.flowers_1800.service.FlowersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/1800-flowers")
public class FlowersController {
	@Autowired
	FlowersService service;

	@GetMapping("/countUniqueUserId")
	public Map<String, Integer> allFlowers() throws JsonMappingException, JsonProcessingException {
		return service.countUsers();
	}

	@PutMapping("/updateData")
	public List<Flowers> update(@RequestBody Flowers details) throws Exception {
		return service.updateList(details);
	}
}

