package com.user.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableZuulProxy
@EnableRetry
public class AccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessApplication.class, args);
	}



}
