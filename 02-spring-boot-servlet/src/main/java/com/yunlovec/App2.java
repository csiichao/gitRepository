package com.yunlovec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.yunlovec.servlet.SecondServlet;

/**
 * 
 * SpringBoot整合Servlet方式二
 */
@SpringBootApplication
public class App2 {
	public static void main(String[] args) {
		SpringApplication.run(App2.class, args);
	}
	@Bean
	public ServletRegistrationBean geServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
}
