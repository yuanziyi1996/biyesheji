package com.xmy.qunar;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xmy.dao.PointMapper;
import com.xmy.po.Point;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.selector.Selectable;

public class QunarPipeline implements Pipeline {

	private static final Logger log = LoggerFactory.getLogger(QunarPipeline.class);

	@Autowired
	private PointMapper pointMapper;

	@Override
	public void process(ResultItems items, Task task) {

		Selectable xpath = items.get("content");
		List<Selectable> nodes = xpath.nodes();

		for (int i = 0; i < nodes.size(); i++) {
			String id = nodes.get(i).xpath("/div/@data-id").toString();
			String point = nodes.get(i).xpath("/div/@data-point").toString();
			String saleCount = nodes.get(i).xpath("/div/@data-sale-count").toString();

			Point record = null;
			int count = 0;
			String sightId = "", lng = "", lat = "";
			try {
				sightId = id;
				String[] split = point.split(",");
				lng = split[0];
				lat = split[1];
				count = Integer.parseInt(saleCount);

				record = new Point(sightId, lng, lat, count);
				try {
					pointMapper.insert(record);
				} catch (Exception e) {
					// 插入数据出错
					try {
						Point p = pointMapper.selectByPrimaryKey(record.getId());
						p.setCount(p.getCount() + record.getCount());
						pointMapper.updateByPrimaryKey(p);
					} catch (Exception e2) {
						log.error(e2.getMessage());
					}
				}

			} catch (Exception e) {
				log.error("xpath解析的数据异常, id : " + id + ", point : " + point + ", saleCount : " + saleCount);
			}
		}
		// for循环结束

	}

}
