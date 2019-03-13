package com.xmy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan(basePackages = { "com.xmy.dao" })
@EnableCaching
@ComponentScan(basePackages={"com.xmy"})
@Configuration
public class QunarTicketSpiderApplication {

	public static void main(String[] args) {
		SpringApplication.run(QunarTicketSpiderApplication.class, args);
	}
}
