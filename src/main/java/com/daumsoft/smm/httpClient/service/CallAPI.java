package com.daumsoft.smm.httpClient.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.daumsoft.smm.httpClient.config.RestTemplateConfiguration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CallAPI {

  private static final Logger logger = LoggerFactory.getLogger(CallAPI.class);

  private final ObjectMapper objectMapper;
  private final RestTemplateConfiguration template;

  public CallAPI (RestTemplateConfiguration template, ObjectMapper objectMapper)  {
    this.template = template;
    this.objectMapper = objectMapper;
  }  
  
  /**
   * API 호출 메소드 (GET)
   * 
   * @param url
   * @param parameter
   * @return
   */
  public JsonNode callGet(String url, JSONObject parameter) {
    try {
      HttpHeaders headers = template.getHeaders();
      HttpEntity<String> entity = new HttpEntity<String>(headers);

      logger.debug("START API(GET) CALLING >>>>> ");
      
      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
      UriComponents uriComponent = null;
      
      if (parameter != null)  {
        for (Object key : parameter.keySet()) {
          String name = String.valueOf(key.toString());
          String values = String.valueOf(parameter.get(name).toString());

          builder.queryParam(name, values);
        }

        uriComponent = builder.build();
      } else {
        uriComponent = builder.build();
      }

      ResponseEntity<String> result = template.getRestTemplate().exchange(uriComponent.toUriString(), HttpMethod.GET, entity, String.class);

      logger.debug("END API(GET) CALLING >>>>> ");

      if (result.getBody() == null) {
        return null;
      }

      return objectMapper.readTree(result.getBody());
    } catch (RestClientException e) {
      e.printStackTrace();
      return null;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  /**
   * API 호출 메소드 (POST)
   * 
   * @param url
   * @param parameters
   * @return
   */
  public JsonNode callPost(String url, JSONObject parameter) {
    try {
      HttpHeaders headers = template.getHeaders();
      HttpEntity<String> entity = new HttpEntity<String>(headers);

      logger.debug("START API(GET) CALLING >>>>> ");

      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
      UriComponents uriComponent = null;

      if (parameter != null) {
        for (Object key : parameter.keySet()) {
          String name = String.valueOf(key.toString());
          String values = String.valueOf(parameter.get(name).toString());

          builder.queryParam(name, values);
        }

        uriComponent = builder.build();
      } else {
        uriComponent = builder.build();
      }

      ResponseEntity<String> result = template.getRestTemplate().exchange(uriComponent.toUriString(), HttpMethod.POST, entity, String.class);

      logger.debug("END API(GET) CALLING >>>>> ");

      if (result.getBody() == null) {
        return null;
      }

      return objectMapper.readTree(result.getBody());
    } catch (RestClientException e) {
      e.printStackTrace();
      return null;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    // try {
    //   String param = "";

    //   if (parameter != null)  {
    //     param = parameter.toJSONString();
    //   }

    //   HttpHeaders headers = template.getHeaders();
    //   HttpEntity<String> entity = new HttpEntity<String>(param, headers);
    //   logger.debug("START API(POST) CALLING >>>>> ");
    //   ResponseEntity<String> result = template.getRestTemplate().postForEntity(url, entity, String.class);
    //   logger.debug("END API(POST) CALLING >>>>> ");
    //   return objectMapper.readTree(result.getBody());
    // } catch (RestClientException e) {
    //   e.printStackTrace();
    //   return null;
    // } catch (IOException e) {
    //   e.printStackTrace();
    //   return null;
    // } catch (Exception e) {
    //   e.printStackTrace();
    //   return null;
    // }
  }
  
}