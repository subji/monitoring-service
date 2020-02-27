package com.daumsoft.smm.httpClient.config;

import java.util.concurrent.TimeUnit;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * HttpClientConfiguration
 * Http 통신은 기본적으로 Pool 이 없다.
 * 그래서 아래와 같이 설정해준다.
 */
@Configuration
@EnableScheduling
public class HttpClientConfiguration {
  // CONNECT TIMEOUT: 연결되기까지의 최대 시간
  // REQUEST TIMEOUT: 커넥션풀에서 커넥션을 가져오기까지의 최대 시간
  // SOCKET TIMEOUT: 데이터 응답까지의 최대 시간
  private static final int SOCKET_TIMEOUT = 60000;
  private static final int CONNECT_TIMEOUT = 30000;
  private static final int REQUEST_TIMEOUT = 30000;
  // MAX_THREAD_POOL_SIZE: 스케줄러 쓰레드 풀 사이즈
  private static final int MAX_THREAD_POOL_SIZE = 5;
  // MAX TOTAL CONNECTIONS: 최개 커넥션 수
  // MAX ROUTE CONNECTIONS: 최대 라우터 수
  // MAX LOCALHOST CONNECTIONS: 로컬 최대 커넥션 수
  private static final int MAX_TOTAL_CONNECTIONS = 50;
  private static final int MAX_ROUTE_CONNECTIONS = 50;
  private static final int MAX_LOCALHOST_CONNECTIONS = 50;
  // IDLE CONNECTION WAIT TIME: 커넥션 유휴 대기 시간
  private static final int IDLE_CONNECTION_WAIT_TIME = 30;
  // DEFAULT KEEP ALIVE MILLS: KeepAlive 유지 시간
  private static final int DEFAULT_KEEP_ALIVE_MILLS = 20 * 1000;

  /**
   * 커넥션 풀 관리 메소드
   * 커넥션의 최대 개수, 커넥션 라우터의 최대 개수를 설정한다.
   * @return
   */
  @Bean
  public PoolingHttpClientConnectionManager poolingConnectionManager() {
    PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
    poolingConnectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
    poolingConnectionManager.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
    
    HttpHost localhost = new HttpHost("http://localhost", 8080);
    poolingConnectionManager.setMaxPerRoute(new HttpRoute(localhost), MAX_LOCALHOST_CONNECTIONS);
    return poolingConnectionManager;
  }

  /**
   * 커넥션의 KeepAlive 전략 설정 메소드
   * 연결이 사용되지 않을때 유지시간을 지정해주고 
   * 정해진 시간 이후에는 연결을 종료시킨다.
   * @return ConnectionKeepAliveStrategy
   */
  @Bean
  public ConnectionKeepAliveStrategy connectionKeepAliveStrategy() {
    return (httpResponse, httpContext) -> {
      HeaderIterator headerIterator = httpResponse.headerIterator(HTTP.CONN_KEEP_ALIVE);
      HeaderElementIterator elementIterator = new BasicHeaderElementIterator(headerIterator);

      while (elementIterator.hasNext()) {
        HeaderElement element = elementIterator.nextElement();
        String param = element.getName();
        String value = element.getValue();

        if (value != null && param.equalsIgnoreCase("timeout")) {
          return Integer.parseInt(value) * 1000;
        }
      }
      
      return DEFAULT_KEEP_ALIVE_MILLS;
    };
  }

  /**
   * 커넥션의 유휴타임 관리 메소드
   * 20 초 마다 종료되는 연결, 오래 지속되는 연결외에도 유휴시간이 오래된 연결을 종료하는 메소드
   * @param pool
   * @return
   */
  @Bean
  public Runnable idleConnectionMonitor(PoolingHttpClientConnectionManager pool) {
    return new Runnable() {
      @Override
      @Scheduled(fixedDelay = 20000)
      public void run() {
        if (pool != null) {
          pool.closeExpiredConnections();
          pool.closeIdleConnections(IDLE_CONNECTION_WAIT_TIME, TimeUnit.MILLISECONDS);
        }
      }
    };
  }
  
  /**
   * 쓰레드 풀 스케쥴러를 반환하는 메소드. 
   * 위 작업들을 자동으로 실행하기 위해 스레드풀을 생성하고 실행한다.
   * @return scheduler
   */
  @Bean
  public TaskScheduler taskScheduler() {
    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    scheduler.setPoolSize(MAX_THREAD_POOL_SIZE);
    scheduler.setThreadNamePrefix("idleMonitor");
    return scheduler;
  }

  /**
   * HttpClient 의 커넥션 설정 메소드
   * @return
   */
  @Bean
  public CloseableHttpClient httpClient() {
    RequestConfig requestConfig = RequestConfig.custom()
      .setSocketTimeout(SOCKET_TIMEOUT)
      .setConnectTimeout(CONNECT_TIMEOUT)
      .setConnectionRequestTimeout(REQUEST_TIMEOUT)
      .build();
      
    return HttpClients.custom()
      .setDefaultRequestConfig(requestConfig)
      .setConnectionManager(poolingConnectionManager())
      .setKeepAliveStrategy(connectionKeepAliveStrategy())
      .build();
  }
  
}