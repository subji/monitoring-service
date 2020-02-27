package com.daumsoft.smm.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PageControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void 로그인_안하고_인덱스_페이지_이동_테스트 () throws Exception {
    mvc.perform(get("/index")).andExpect(status().isOk());
  }

  @Test
  public void 로그인_안하고_수집현황_페이지_이동_테스트 () throws Exception {
    mvc.perform(get("/buzz")).andExpect(status().isOk());
  }
  
}