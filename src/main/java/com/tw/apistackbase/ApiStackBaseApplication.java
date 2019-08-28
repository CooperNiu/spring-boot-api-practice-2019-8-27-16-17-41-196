package com.tw.apistackbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ApiStackBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStackBaseApplication.class, args);
	}
}
