package com.demo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.AppConfig;
import com.demo.model.Blog;
import com.demo.service.BlogService;

public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		BlogService blogService = applicationContext.getBean("service", BlogService.class);
		int i = 1;
		for (Blog blog : blogService.findAll()) {
			System.out.println("blog" + i);
			System.out.println("title : " + blog.getTitle());
			System.out.println("summary : " + blog.getSummary());
			i++;		
		}
	}
}
