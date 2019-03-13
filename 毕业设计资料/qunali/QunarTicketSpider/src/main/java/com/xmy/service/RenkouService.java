package com.xmy.service;

import com.xmy.dao.RenkouMapper;
import com.xmy.po.Renkou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RenkouService {
  @Autowired
  RenkouMapper renkouMapper;

  public List<Renkou> getAll() {
    System.out.println("Renkou.getAll()");
    /*List result = new ArrayList();
    result = renkouMapper.getAll();*/
    return renkouMapper.getAll();
  }

  public Integer count(){
    return renkouMapper.count();
  }
  public List<Renkou> getInfo() {
    System.out.println("Renkou.getInfo()");
    /*List result = new ArrayList();
    result = renkouMapper.getAll();*/
    return renkouMapper.getInfo();
  }

}
