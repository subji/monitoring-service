package com.daumsoft.smm.hist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daumsoft.smm.common.dto.ResponseResultDTO;
import com.daumsoft.smm.constant.HTTP;
import com.daumsoft.smm.hist.dto.HistDTO;
import com.daumsoft.smm.hist.service.HistService;

import org.apache.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistController {

  private final HistService histService;

  public HistController(HistService histService) {
    this.histService = histService;
  }

  @RequestMapping(value = "/api/log/{type}", method = { RequestMethod.GET, RequestMethod.POST })
  public ResponseResultDTO getHistLogin(HttpServletRequest request, HttpServletResponse response,
      @PathVariable("type") String type, @RequestParam String url, @RequestParam String startDate, @RequestParam String endDate, Model model) {
    HistDTO histDTO = new HistDTO();
    histDTO.setUrl(url);
    histDTO.setEndDate(endDate);
    histDTO.setStartDate(startDate);

    ResponseResultDTO res = new ResponseResultDTO();

    try {
      res.setStatus(HttpStatus.SC_OK);
      res.setMessage(HTTP.SUCCESS);
      histDTO.setUrl(histDTO.getUrl() + "/api/log/" + type);
      res.setData(histService.getHistLoginCount(histDTO));
    } catch (Exception e) {
      res.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
      res.setMessage(e.getMessage());
      res.setData(null);
    }

    return res;
  }
  
}