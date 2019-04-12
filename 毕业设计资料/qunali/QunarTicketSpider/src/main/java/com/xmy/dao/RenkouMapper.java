package com.xmy.dao;

import com.xmy.po.Renkou;

import java.util.List;

public interface RenkouMapper {
  List<Renkou> getAll();
  int count();
  //方法的名字对应的是mapper.xml中一条sql的 id
  List<Renkou> getInfo();
}
