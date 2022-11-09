package com.challenge.flowers_1800.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@Value("${Data:http://localhost:}")
	String url;

	@GetMapping("/countUniqueUserId")
	public ResponseEntity<Map<String, Integer>> uniqueUserIds() throws JsonMappingException, JsonProcessingException {
		return new ResponseEntity<Map<String, Integer>>(service.countUsers(url), HttpStatus.OK);
	}

	@PutMapping("/updateData")
	public ResponseEntity<List<Flowers>> update(@RequestBody Flowers details) throws Exception {
		return new ResponseEntity<List<Flowers>>(service.updateList(url, details), HttpStatus.CREATED);
	}
}
