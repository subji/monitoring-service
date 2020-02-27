package com.daumsoft.smm.buzz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daumsoft.smm.buzz.entity.BuzzResult;
import com.daumsoft.smm.buzz.repository.BuzzResultRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuzzResultService {

  private static final Logger logger = LoggerFactory.getLogger(BuzzResultService.class);

  private final BuzzResultRepository buzzResultRepository;

  public BuzzResultService(BuzzResultRepository buzzResultRepository) {
    this.buzzResultRepository = buzzResultRepository;
  }

  public Map<String, List<BuzzResult>> getSumBuzzResultList(String startDate, String endDate) throws Exception {
    List<BuzzResult> list = buzzResultRepository.findSumByPeriod(startDate, endDate);
    Map<String, List<BuzzResult>> result = new HashMap<String, List<BuzzResult>>();

    for (BuzzResult buzz : list) {
      String channel = buzz.getChannel();

      if (result.containsKey(channel)) {
        result.get(channel).add(buzz);
      } else {
        List<BuzzResult> init = new ArrayList<BuzzResult>();
        init.add(buzz);
        result.put(channel, init);
      }
    }

    return result;
  }
  
}