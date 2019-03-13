package com.xmy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xmy.dao.PointMapper;
import com.xmy.po.Point;

@Service
public class PointService {

	@Autowired
	private PointMapper pointMapper;
	
	@Cacheable(value = "points")
	public List<Point> getAll() {

		System.out.println("123123412341234x");
		System.out.println("PointController.getAll()");
		return pointMapper.selectByExample(null);
	}
	
}
