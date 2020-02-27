package com.daumsoft.smm.httpClient.config;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import com.daumsoft.smm.httpClient.handler.CustomHttpClientRequestErrorHandler;
import com.daumsoft.smm.httpClient.interceptor.CustomHttpClientRequestInterceptor;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfiguration
 */
@Configuration
public class RestTemplateConfiguration {

  final CloseableHttpClient httpClient;

  @Autowired
  public RestTemplateConfiguration (CloseableHttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * HttpClientConfiguration 주입된 Bean 을 Apache HTTP 에 연결해주는 메소드
   * HttpComponentsClientHttpRequestFactory 는 내부적으로 Apache HttpComponents 를 사용하여
   * HTTP 요청을 생성한다.
   * Apache HTTP Client 에 연결한다.
   * @return factory
   */
  @Bean
  public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory () {
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    factory.setHttpClient(httpClient);
    return factory;
  }

  /**
   * 요청 헤더 설정 메소드
   * @return headers
   */
  @Bean
  public HttpHeaders getHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    return headers;
  }

  /**
   * Connection Pool, KeepAlive 설정을 반영한 RestTemplate 객체를 반환하는 메소드 
   * UTF-8 적용
   * 인터셉터 적용
   * 에러 핸들러 적용
   * @return restTemplate
   */
  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplateBuilder()
      .interceptors(new CustomHttpClientRequestInterceptor())
      .errorHandler(new CustomHttpClientRequestErrorHandler())
      .requestFactory(this::httpComponentsClientHttpRequestFactory)
      .additionalMessageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8))
      .build();
  }
 
}