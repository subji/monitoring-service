package com.daumsoft.smm.buzz.dto;

import org.springframework.lang.NonNull;

public class BuzzResultDTO {

  private String startDate;
  private String endDate;

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
    return "BuzzResultDTO [endDate=" + endDate + ", startDate=" + startDate + "]";
  }

}