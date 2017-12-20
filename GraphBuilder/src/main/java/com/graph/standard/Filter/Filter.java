package com.graph.standard.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.graph.standard.Filter.ParameterLogFilter;
 
@Configuration
public class Filter
{
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean()
	{
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new ParameterLogFilter());
		return registrationBean;
	}
}