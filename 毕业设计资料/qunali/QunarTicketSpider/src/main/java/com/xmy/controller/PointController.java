package com.xmy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xmy.UpdateAreaParam;
import com.xmy.dao.PointMapper;
import com.xmy.po.Renkou;
import com.xmy.service.RenkouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmy.po.Point;
import com.xmy.service.PointService;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
//@Controller
public class PointController {

	@Autowired
	private PointService pointService;
	@Autowired
	private RenkouService renkouService;
	@Autowired
	private PointMapper pointMapper;

	@ApiOperation(value = "新增用户" ,  notes="新增注册")
	@RequestMapping(value = "/points",method = RequestMethod.GET)
	public Map<String, Object> getPoints() {
		Map<String, Object> map = new HashMap<>();
		System.out.println("开始时间 : " + System.currentTimeMillis());
		List<Point> list = pointService.getAll();
		System.out.println("结束时间 : " + System.currentTimeMillis());
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/renkou",method = RequestMethod.GET)
	public Map<String, Object> getRenkou() {
		Map<String, Object> map = new HashMap<>();
		System.out.println("开始时间 renkou: " + System.currentTimeMillis());
		List<Renkou> list = renkouService.getAll();
		System.out.println("返回人口数据");
		System.out.println("结束时间 : " + System.currentTimeMillis());
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/count",method = RequestMethod.GET)
	public Map<String, Object> getCount() {
		Map<String, Object> map = new HashMap<>();
		Integer count = renkouService.count();
		map.put("count",count);
		System.out.println(map);
		return map;
	}


	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public Map<String, Object> getInfo() {
		Map<String, Object> map = new HashMap<>();
		System.out.println("开始时间 renkou: " + System.currentTimeMillis());
		List<Renkou> list = renkouService.getInfo();
		System.out.println("返回数据");
		System.out.println("结束时间 : " + System.currentTimeMillis());
		map.put("list", list);
		return map;


	}
	@ApiOperation(value = "更新" ,  notes="更新")
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType
		.APPLICATION_JSON_UTF8_VALUE)
	public void setAudioSettings(@RequestBody UpdateAreaParam updateAreaParam){
//		if(StringUtils.isEmpty(updateAreaParam.getLng())){
//			updateAreaParam.setLng(null);
//		}
//		if(StringUtils.isEmpty(updateAreaParam.getLat())){
//
//			updateAreaParam.setLat(null);
//		}
  pointMapper.updateArea(1,updateAreaParam.getLat(),updateAreaParam.getLng());
	}
}
