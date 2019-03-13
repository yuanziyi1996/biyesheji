package com.xmy.qunar;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class QunarPageProcessor implements PageProcessor {

	@Override
	public Site getSite() {
		return Site.me().setRetryTimes(3).setTimeOut(1000);
	}

	@Override
	public void process(Page page) {
		Selectable xpath = page.getHtml().xpath("//*[@id='search-list']/div");
		page.putField("content", xpath);

		Selectable urls = page.getHtml().xpath("//*[@id=\"pager-container\"]/div");
		List<String> all = urls.links().all();
		page.addTargetRequests(all);
	}

}
