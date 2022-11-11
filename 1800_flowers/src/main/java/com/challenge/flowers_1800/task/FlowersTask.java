package com.challenge.flowers_1800.task;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.challenge.flowers_1800.entity.Flowers;
import com.challenge.flowers_1800.exception.FlowersExceptionHandler;

@Service
public class FlowersTask {

	public static final Logger logger = LoggerFactory.getLogger(FlowersExceptionHandler.class);

	public List<Flowers> printUpdates(Flowers details, List<Flowers> list) throws Exception {

		if (list.stream().filter(i -> (i.getUserId() == details.getUserId())).count() != 0) {
			logger.info("Update done for UserId: "+details.getUserId());
			list.stream().map(e -> {
				if (e.getUserId() == details.getUserId()) {
					e.setTitle(details.getTitle());
					e.setBody(details.getBody());
				}
				return e;
			}).collect(Collectors.toList());
			return list;
		}
		logger.error("UserId not found for UserId: "+details.getUserId());
		throw new RuntimeException("UserId not found!");
	}

	public Map<String, Integer> printCount(List<Flowers> list) {

		Map<String, Integer> map1 = new TreeMap<>();
		try {
			logger.info("Unique UserIds count done success");
			Map<Integer, List<Flowers>> map = new TreeMap<>();
			map = list.stream().collect(Collectors.groupingBy(Flowers::getUserId));

			HashSet<Integer> set = new HashSet<>();
			set.addAll(map.keySet());

			map1.put("Unique UserId's", set.size());

		} catch (Exception e) {
			logger.error(e.getMessage());
			new RuntimeException(e.getMessage());
		}
		return map1;
	}

}