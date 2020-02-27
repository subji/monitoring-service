package com.daumsoft.smm.status.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daumsoft.smm.common.dto.ResponseResultDTO;
import com.daumsoft.smm.constant.HTTP;
import com.daumsoft.smm.status.dto.AppStatusDTO;
import com.daumsoft.smm.status.service.AppStatusService;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppStatusController {

  private static final Logger logger = LoggerFactory.getLogger(AppStatusController.class);

  private final AppStatusService service;

  public AppStatusController(AppStatusService service) {
    this.service = service;
  }

  @RequestMapping(value = "/status", method = { RequestMethod.GET, RequestMethod.POST })
  public ResponseResultDTO getApplicationHealthStatus(HttpServletRequest request, HttpServletResponse response,
      @RequestParam String applicationName, Model model) {
    AppStatusDTO appStatusDTO = new AppStatusDTO();
    appStatusDTO.setApplicationName(applicationName);

    ResponseResultDTO res = new ResponseResultDTO();

    try {
      res.setStatus(HttpStatus.SC_OK);
      res.setMessage(HTTP.SUCCESS);
      res.setData(service.getApplicationStatus(appStatusDTO));
    } catch (Exception e) {
      res.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
      res.setMessage(e.getMessage());
      res.setData(null);
    }

    return res;
  }
  
}