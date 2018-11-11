package com.yunlovec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBoot整合filter方式一
 *
 */
@SpringBootApplication
@ServletComponentScan
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
