package com.iiht.dating.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.iiht.dating")
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
//	public CommonsMultipartResolver getMultipartResolver(){
//		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//		resolver.setMaxUploadSize(10000000L);
//		return resolver;
//	}
		
	/*
	 * <bean id="multipartResolver"
	 * class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	 * 
	 * <!-- one of the properties available; the maximum file size in bytes -->
	 * <property name="maxUploadSize" value="10000000" /> </bean>
	 */
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}	
}