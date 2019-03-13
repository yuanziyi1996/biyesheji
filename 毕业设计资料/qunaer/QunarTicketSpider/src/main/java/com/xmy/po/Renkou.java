package com.xmy.po;

public class Renkou {
  private static final long serialVersionUID = 1L;

  private String areaId;

  private String lng;

  private String lat;

  private String renkou;

  private String areaCode;

  private String areaName;

  private int level;

  private String cityCode;

  private String parentId;

  private String center;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getAreaId() {
    return areaId;
  }

  public void setAreaId(String areaId) {
    this.areaId = areaId;
  }

  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getRenkou() {
    return renkou;
  }

  public void setRenkou(String renkou) {
    this.renkou = renkou;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getCenter() {
    return center;
  }

  public void setCenter(String center) {
    this.center = center;
  }
}
