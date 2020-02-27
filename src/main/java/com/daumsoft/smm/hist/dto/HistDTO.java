package com.daumsoft.smm.hist.dto;

public class HistDTO {

  private String url;
  private String startDate;
  private String endDate;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "HistDTO [endDate=" + endDate + ", startDate=" + startDate + ", url=" + url + "]";
  }
  
}