package com.xmy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xmy.po.Renkou;
import com.xmy.service.RenkouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmy.po.Point;
import com.xmy.service.PointService;

@RestController
//@Controller
public class PointController {

	@Autowired
	private PointService pointService;
	@Autowired
	private RenkouService renkouService;

	@RequestMapping("points")
	public Map<String, Object> getPoints() {
		Map<String, Object> map = new HashMap<>();
		System.out.println("开始时间 : " + System.currentTimeMillis());
		List<Point> list = pointService.getAll();
		System.out.println("结束时间 : " + System.currentTimeMillis());
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "renkou",method = RequestMethod.GET)
	public Map<String, Object> getRenkou() {
		Map<String, Object> map = new HashMap<>();
		System.out.println("开始时间 renkou: " + System.currentTimeMillis());
		List<Renkou> list = renkouService.getAll();
		System.out.println("返回人口数据");
		System.out.println("结束时间 : " + System.currentTimeMillis());
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "count",method = RequestMethod.GET)
	public Map<String, Object> getCount() {
		Map<String, Object> map = new HashMap<>();
		Integer count = renkouService.count();
		map.put("count",count);
		System.out.println(map);
		return map;
	}


	@RequestMapping(value = "get",method = RequestMethod.GET)
	public Map<String, Object> getInfo() {
		Map<String, Object> map = new HashMap<>();
		System.out.println("开始时间 renkou: " + System.currentTimeMillis());
		List<Renkou> list = renkouService.getInfo();
		System.out.println("返回数据");
		System.out.println("结束时间 : " + System.currentTimeMillis());
		map.put("list", list);
		return map;
	}
}
