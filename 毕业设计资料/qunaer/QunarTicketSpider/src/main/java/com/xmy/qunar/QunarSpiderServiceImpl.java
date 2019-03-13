package com.xmy.qunar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.codecraft.webmagic.Spider;

@Service("qunarSpiderService")
public class QunarSpiderServiceImpl implements SpiderService {

	@Autowired
	private Spider spider;

	@Override
	public void run() {
		spider.run();
	}

}
