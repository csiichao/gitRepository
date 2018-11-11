package com.yunlovec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.yunlovec.filter.SecondFilter;
import com.yunlovec.servlet.SecondServlet;

/**
 * SpringBoot整合filter方式二 
 *
 */

@SpringBootApplication
public class APP2 {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	/**
	 * 注册servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getsServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
	
	/**
	 * 注册Filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getFilRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
//		bean.addUrlPatterns(new String[] {"*.do","*.jsp"});
		bean.addUrlPatterns("/second");
		return bean;
	}
}
