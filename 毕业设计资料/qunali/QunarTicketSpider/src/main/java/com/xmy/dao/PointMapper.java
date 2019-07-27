package com.xmy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xmy.po.Point;
import com.xmy.po.PointExample;
import org.apache.ibatis.annotations.Update;

public interface PointMapper {
	int countByExample(PointExample example);

	int deleteByExample(PointExample example);

	int deleteByPrimaryKey(String id);

	int insert(Point record);

	int insertSelective(Point record);

	List<Point> selectByExample(PointExample example);

	Point selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Point record, @Param("example") PointExample example);

	int updateByExample(@Param("record") Point record, @Param("example") PointExample example);

	int updateByPrimaryKeySelective(Point record);

	int updateByPrimaryKey(Point record);

	@Update("<script>"
			+ " update "
		+ " point"
		+ " <set> "
		+ " lat =(case when( #{lat} is not null and #{lat} !='') then #{lat} else lat end), "
		+ " lng =(case when( #{lng} is not null and #{lng} !='') then #{lng} else lng end) "
		+ " </set>"
		+ " where id = #{id}"
		+ "</script>"
	)
	int updateArea(@Param("id") long id,
								 @Param("lat") String lat,
								 @Param("lng") String lng);
}