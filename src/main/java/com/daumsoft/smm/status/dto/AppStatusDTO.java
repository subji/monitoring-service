package com.daumsoft.smm.status.dto;

public class AppStatusDTO {

  private String applicationName;

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  @Override
  public String toString() {
    return "AppStatusDTO [applicationName=" + applicationName + "]";
  }
  
}