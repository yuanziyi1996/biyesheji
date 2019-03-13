package com.xmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xmy.qunar.SpiderService;

@Controller
public class SpiderController {

	@Autowired
	private SpiderService spiderService;

	@RequestMapping("spider/run")
	public String run() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				spiderService.run();
			}
		}).start();
		return "index";
	}

}
