package com.lai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.lai.login.AuthenticateFilter;

@SpringBootApplication
public class AssignmentLaintpd02389Sof302Application {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentLaintpd02389Sof302Application.class, args);
	}
	@Bean
	public FilterRegistrationBean<AuthenticateFilter> authenticateFilter(){
		FilterRegistrationBean<AuthenticateFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new AuthenticateFilter());
		registrationBean.addUrlPatterns("/departs/*");
		registrationBean.addUrlPatterns("/records/*");
		registrationBean.addUrlPatterns("/staffs/*");
//		registrationBean.addUrlPatterns("/users/*");
		registrationBean.addUrlPatterns("/records/Report/");
		return registrationBean;
	} 

}
