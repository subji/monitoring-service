package com.daumsoft.smm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration // Failed to load ApplicationContext 처리
// 테스트 클래스는 반드시 public 으로 한다.
public class SocialMetricsMonitoringApplicationTests {

  @Test
  public void 기본_테스트 ()  {

  }

}
