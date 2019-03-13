package com.xmy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmy.po.Point;
import com.xmy.service.PointService;

@RestController
public class PointController {

	@Autowired
	private PointService pointService;

	@RequestMapping("points")
	public Map<String, Object> getPoints() {
		Map<String, Object> map = new HashMap<>();
		System.out.println("开始时间 : " + System.currentTimeMillis());
		List<Point> list = pointService.getAll();
		System.out.println("结束时间 : " + System.currentTimeMillis());
		map.put("list", list);
		return map;
	}

}

 /* @RequestMapping("renkou")
	public Map<String,Object> getRenKou(){
		Map<String, Object> map = new HashMap<>();
		List<Renkou> list = renkouService.getAll();

		map.put("list", list);
		return map;
	}*/


