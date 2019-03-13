package com.xmy.dao;

import com.xmy.po.Renkou;

import java.util.List;

public interface RenkouMapper {
  List<Renkou> getAll();
  int count();
  List<Renkou> getInfo();
}
