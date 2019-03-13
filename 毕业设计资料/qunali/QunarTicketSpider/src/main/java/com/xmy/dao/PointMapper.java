package com.xmy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xmy.po.Point;
import com.xmy.po.PointExample;

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
}