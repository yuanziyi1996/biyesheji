package com.xmy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = { "com.xmy.dao" })
@EnableCaching
public class QunarTicketSpiderApplication {

	public static void main(String[] args) {
		SpringApplication.run(QunarTicketSpiderApplication.class, args);
	}
}
