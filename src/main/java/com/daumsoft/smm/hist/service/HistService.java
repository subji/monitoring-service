package com.daumsoft.smm.hist.service;

import com.daumsoft.smm.hist.dto.HistDTO;
import com.daumsoft.smm.httpClient.service.CallAPI;
import com.fasterxml.jackson.databind.JsonNode;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HistService {

  private static final Logger logger = LoggerFactory.getLogger(HistService.class);

  private final CallAPI callApi;

  public HistService (CallAPI callApi)  {
    this.callApi = callApi;
  }

  public Object getHistLoginCount (HistDTO histDTO) throws Exception {

    JSONObject parameter = new JSONObject();
    parameter.put("startDate", histDTO.getStartDate());
    parameter.put("endDate", histDTO.getEndDate()); 

    logger.debug("START DATE >>>>> " + histDTO.getStartDate());
    logger.debug("END DATE >>>>>  " + histDTO.getEndDate());

    JsonNode res = callApi.callPost(histDTO.getUrl(), parameter);
    
    if (res.get("status").asText().equals("200") && res.get("message").asText().equals("SUCCESS")) {
      return res.get("data");
    } else {
      throw new Exception("Cannot get Data");
    }
  }
}