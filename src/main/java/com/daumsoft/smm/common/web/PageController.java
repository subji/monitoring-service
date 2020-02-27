package com.daumsoft.smm.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/** 
 * Index Controller 
*/
@Controller
public class PageController {

  @GetMapping({ "/", "/index" }) 
  public String index (Model model)  {
    return "index/index";
  }

  @GetMapping({ "/buzz" })
  public String buzzResult (Model model)  {
    return "buzzResult/buzzResult";
  }

  @GetMapping({ "/hist" })
  public String histResult (Model model)  {
    return "hist/hist";
  }
  
}