package com.daumsoft.smm.mvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class BuzzResultApiControllerTest {

  @Autowired
  private MockMvc mvc;

  @Before
  public void login ()  {

  }

  @Test
  public void 버즈_합계량_API_테스트 () throws Exception {
    MvcResult res = mvc.perform(
      post("/api/buzz_sum")
      .header("Content-Type", "application/json;charset=utf-8")
      .content("{\"startDate\":\"20200101\",\"endDate:\":\"20200131\"}")
    )
    .andExpect(status().isOk())
    // .andExpect(content().string("{\"status\":200,\"message\":\"SUCCESS\",\"data\":\""))
    .andReturn();

    assertEquals(
      res.getResponse().getContentAsString().substring(0, 42), 
      "{\"status\":200,\"message\":\"SUCCESS\",\"data\":\""
    );
  }
  
}