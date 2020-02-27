package com.daumsoft.smm.status.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.daumsoft.smm.httpClient.service.CallAPI;
import com.daumsoft.smm.status.dto.AppStatusDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AppStatusService {

  private static final Logger logger = LoggerFactory.getLogger(AppStatusService.class);
  private static final Map<String, String> app;
  
  private final CallAPI callApi;
  
  static {
    Map<String, String> apps = new HashMap<String, String>();
    apps.put("querytool", "https://querytool.some.co.kr/health");
    apps.put("sbs", "http://social.sbs.co.kr/health");
    app = Collections.unmodifiableMap(apps);
  }
  
  public AppStatusService (CallAPI callApi)  {
    this.callApi = callApi;
  }

  public Object getApplicationStatus (AppStatusDTO appStatusDTO) throws Exception { 
    return callApi.callGet(app.get(appStatusDTO.getApplicationName()), null);
  }
  
}