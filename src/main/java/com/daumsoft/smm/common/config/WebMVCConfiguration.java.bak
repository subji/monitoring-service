package com.daumsoft.monitoring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * WebMVCConfiguration
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.daumsoft.monitoring")
public class WebMVCConfiguration implements WebMvcConfigurer {

  private static final Logger logger = LoggerFactory.getLogger(WebMVCConfiguration.class);

  private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { 
		"classpath:/lib/", 
		"classpath:/public/",
		"classpath:/static/", 
		"classpath:/resources/", 
		"classpath:/META-INF/resources/",
	};

  @Override
  public void addResourceHandlers (ResourceHandlerRegistry registry)  {
    registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
  }

  @Override
  public void configureViewResolvers (ViewResolverRegistry registry) {
    InternalResourceViewResolver bean = new InternalResourceViewResolver();
    bean.setSuffix(".jsp");
    bean.setPrefix("/WEB-INF/views/");
    bean.setViewClass(JstlView.class);
    registry.viewResolver(bean);
  }

}