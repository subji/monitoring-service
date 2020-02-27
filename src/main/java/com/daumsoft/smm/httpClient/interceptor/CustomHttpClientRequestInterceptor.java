package com.daumsoft.smm.httpClient.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * HTTP Client 요청 인터셉터 객체
 */
public class CustomHttpClientRequestInterceptor implements ClientHttpRequestInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(CustomHttpClientRequestInterceptor.class);

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

    logger.info("URI: {}", request.getURI());
    logger.info("HTTP Method: {}", request.getMethod());
    logger.info("HTTP Headers: {}", request.getHeaders());

    return execution.execute(request, body);
  }
  
}