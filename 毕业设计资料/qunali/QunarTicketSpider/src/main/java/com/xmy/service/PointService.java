package com.xmy.service;

import java.util.List;

import com.xmy.dao.RenkouMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xmy.dao.PointMapper;
import com.xmy.po.Point;

@Service
public class PointService {

	@Autowired
	private PointMapper pointMapper;

	@Autowired
	private RenkouMapper renkouMapper;
	
	@Cacheable(value = "points")
	public List<Point> getAll() {
		System.out.println("PointController.getAll()");
		int a = renkouMapper.count();
		System.out.println(a);
		return pointMapper.selectByExample(null);
	}
	
}
