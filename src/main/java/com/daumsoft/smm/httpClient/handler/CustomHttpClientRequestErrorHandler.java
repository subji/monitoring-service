package com.daumsoft.smm.httpClient.handler;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * CustomClientErrorHandler
 */
public class CustomHttpClientRequestErrorHandler implements ResponseErrorHandler {

  private static final Logger logger = LoggerFactory.getLogger(CustomHttpClientRequestErrorHandler.class);

  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    return response.getStatusCode().is4xxClientError();
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    logger.error("HTTP Status Code: " + response.getStatusCode().value());
    logger.error("HTTP Status Text: " + response.getStatusText());
  }
  
}