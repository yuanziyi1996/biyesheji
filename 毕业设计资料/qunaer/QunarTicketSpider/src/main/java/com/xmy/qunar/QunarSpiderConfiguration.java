package com.xmy.qunar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.RedisScheduler;
import us.codecraft.webmagic.scheduler.Scheduler;

/**
 * @Description: 去哪儿网爬虫
 * @author 闲明苑
 * @date 2017年10月2日 下午5:25:09
 */
@Configuration
public class QunarSpiderConfiguration {

	/**
	 * 实例化解析器
	 */
	@Bean
	public PageProcessor getPageProcessor() {
		return new QunarPageProcessor();
	}

	/**
	 * 实例化管道
	 */
	@Bean
	public Pipeline getPipeline() {
		// 实例化自定义管道
		return new QunarPipeline();
		// 实例化输出Json文件管道
		// return new JsonFilePipeline("H:\\webmagic\\");
		// 实例化控制台管道
		// return new ConsolePipeline();
	}

	/**
	 * 实例化爬虫
	 */
	@Bean
	public Spider getSpider() {
		Spider qunarSpider = Spider.create(getPageProcessor()).addPipeline(getPipeline())
				.addUrl("http://piao.qunar.com/ticket/list_海南.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_广东.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_广西.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_上海.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_江西.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_山东.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_安徽.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_浙江.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_江苏.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_福建.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_新疆.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_宁夏.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_甘肃.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_陕西.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_青海.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_湖北.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_湖南.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_河南.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_辽宁.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_黑龙江.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_吉林.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_云南.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_重庆.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_四川.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_贵州.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_西藏.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_北京.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_天津.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_河北.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_山西.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_内蒙古.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_香港.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_台湾.html?from=mps_search_suggest&page=1",
						"http://piao.qunar.com/ticket/list_澳门.html?from=mps_search_suggest&page=1")
				.thread(5);// 线程数不能大于PageProcessor每次加入的url条数，同样也不能大于初始化刚加入的url数，不然会发生奇妙的错误
		// 分布式存在问题。还有线程未执行完毕,
		// 爬虫向队列询问url时,返回null,此时所有线程执行完毕,但是又有新的url加入了队列,然而Spider判定为爬取完毕了
		Scheduler scheduler = new RedisScheduler("127.0.0.1");
		qunarSpider.setScheduler(scheduler);
		// try {
		// SpiderMonitor.instance().register(qunarSpider);
		// } catch (JMException e) {
		// log.debug(e.getMessage());
		// }
		return qunarSpider;
	}
}
