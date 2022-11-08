package com.challenge.flowers_1800.task;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.challenge.flowers_1800.entity.Flowers;
import com.challenge.flowers_1800.exception.FlowersExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FlowersTask {

	ObjectMapper obj = new ObjectMapper();

	FlowersTask restClient;

	Flowers details;

	public static final Logger logger = LoggerFactory.getLogger(FlowersExceptionHandler.class);
	
	boolean update = false;

	public List<Flowers> printUpdates(Flowers details, List<Flowers> list) throws Exception {
		
			update = false;

			Predicate<Flowers> predicate = i -> i.getUserId() == details.getUserId();
			list.stream().forEach(i -> {
				if (predicate.test(i)) {
					i.setTitle(details.getTitle());
					i.setBody(details.getBody());
					update = predicate.test(i);
				}

			});
			if (update == true) {
				return list;
			}
			logger.error("UserId not found!");
			throw new RuntimeException("UserId not found!");
	}

	public Map<String, Integer> printCount(List<Flowers> list) {

		Map<String, Integer> map1 = new TreeMap<>();
		try {
			Map<Integer, List<Flowers>> map = new TreeMap<>();
			map = list.stream().collect(Collectors.groupingBy(Flowers::getUserId));

			HashSet<Integer> set = new HashSet<>();
			set.addAll(map.keySet());

			map1.put("Unique UserId's", set.size());

		} catch (Exception e) {
			new RuntimeException(e.getMessage());
		}
		return map1;
	}

}