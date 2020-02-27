package com.daumsoft.smm.buzz.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daumsoft.smm.buzz.dto.BuzzResultDTO;
import com.daumsoft.smm.buzz.entity.BuzzResult;
import com.daumsoft.smm.buzz.service.BuzzResultService;
import com.daumsoft.smm.common.dto.ResponseResultDTO;
import com.daumsoft.smm.constant.HTTP;

import org.apache.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuzzResultController {

  private final BuzzResultService buzzResultService;

  public BuzzResultController(BuzzResultService buzzResultService) {
    this.buzzResultService = buzzResultService;
  }

  @RequestMapping(value = "/api/buzz_sum", method = { RequestMethod.POST, RequestMethod.GET })
  public ResponseResultDTO getSumBuzzResultList(HttpServletRequest request, HttpServletResponse response, @RequestParam String startDate, @RequestParam String endDate, Model model) {
    BuzzResultDTO buzzResultDTO = new BuzzResultDTO();
    buzzResultDTO.setStartDate(startDate);
    buzzResultDTO.setEndDate(endDate);

    ResponseResultDTO res = new ResponseResultDTO();

    try {
      Map<String, List<BuzzResult>> ret = buzzResultService.getSumBuzzResultList(buzzResultDTO.getStartDate(), buzzResultDTO.getEndDate());
      res.setStatus(HttpStatus.SC_OK);
      res.setMessage(HTTP.SUCCESS);
      res.setData(ret);
    } catch (Exception e) {
      res.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
      res.setMessage(e.getMessage());
      res.setData(null);  
    }
    
    return res;
  }
  
}